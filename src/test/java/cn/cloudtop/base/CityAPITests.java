package cn.cloudtop.base;

import cn.cloudtop.zone.ZoneServiceApplication;
import cn.cloudtop.zone.controllers.city.CityVo;
import cn.cloudtop.zone.controllers.province.ProvinceVo;
import cn.cloudtop.zone.exceptions.ErrorCode;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * Created by jackie on 16-5-17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ZoneServiceApplication.class)
@WebAppConfiguration
@IntegrationTest
public class CityAPITests extends TestBase {
    @Test
    public void test_get_cities() {
        given().
                log().all().
                when()
                .get("/zone/city")
                .then()
                .log().all()
                .statusCode(200)
                .body("cities.pinyin", hasItems("Fuzhou", "Xiamen"))
                .body("cities.id", hasSize(2));
    }

    @Test
    public void test_create_city() {
        given().log().all()
                .header("Content-Type", "application/json;charset=utf-8")
                .body(new CityVo("莆田市", "莆田", "Putian", "119.007558", "25.431011", "0594", "351100", fujiansheng.getId()))
                .when().post("/zone/city")
                .then().log().all()
                .statusCode(200)
                .body("city.id", notNullValue())
                .body("city.name", equalTo("莆田市"))
                .body("city.pinyin", equalTo("Putian"));
    }

    private RequestSpecification givens() {
        return given().log().all().header("Content-Type", "application/json;charset=utf-8");
    }

    @Test
    public void test_get_city() {
        given().log().all().header("Content-Type", "application/json;charset=utf-8")
                .when().get("/zone/city/" + xiamen.getId())
                .then().log().all()
                .statusCode(200)
                .body("city.id", notNullValue())
                .body("city.id", equalTo(xiamen.getId()));
    }

    @Test
    public void test_get_city_throw_city_not_exists_exception() {
        givens().when().get("/zone/city/11111111111111111111111111111111")
                .then().log().all()
                .statusCode(200)
                .body("success", equalTo(false))
                .body("errorCode", equalTo(ErrorCode.City_Not_Existed));
    }

    @Test
    public void test_get_city_districtCountry() {
        givens().when().get(String.format("/zone/city/%s/districtCounties", xiamen.getId()))
                .then().log().all()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("districtCountries", hasSize(2));
    }
}
