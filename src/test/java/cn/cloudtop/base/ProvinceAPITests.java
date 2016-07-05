package cn.cloudtop.base;

import cn.cloudtop.zone.ZoneServiceApplication;
import cn.cloudtop.zone.controllers.province.ProvinceVo;
import cn.cloudtop.zone.controllers.ErrorCode;
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
 * Created by jackie on 16-5-16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ZoneServiceApplication.class)
@WebAppConfiguration
@IntegrationTest
public class ProvinceAPITests extends TestBase {

    @Test
    public void test_get_provinces() {
        given().
                log().all().
                when()
                .get("/zone/province")
                .then()
                .log().all()
                .statusCode(200)
                .body("provinces.pinyin", hasItems("Beijing", "Fujian"))
                .body("provinces.id", hasSize(2));
    }

    @Test
    public void test_create_province() {
        given().log().all()
                .header("Content-Type", "application/json;charset=utf-8")
                .body(new ProvinceVo("安徽省", "安徽", "Anhui", "117.283042", "31.86119", china.getId()))
                .when().post("/zone/country")
                .then().log().all()
                .statusCode(200)
                .body("country.id", notNullValue())
                .body("country.name", equalTo("安徽省"))
                .body("country.pinyin", equalTo("Anhui"));
    }

    private RequestSpecification givens() {
        return given().log().all().header("Content-Type", "application/json;charset=utf-8");
    }

    @Test
    public void test_get_province() {
        given().log().all().header("Content-Type", "application/json;charset=utf-8")
                .when().get("/zone/province/" + beijing.getId())
                .then().log().all()
                .statusCode(200)
                .body("province.id", notNullValue())
                .body("province.id", equalTo(beijing.getId()));
    }

    @Test
    public void test_get_province_throw_province_not_exists_exception() {
        givens().when().get("/zone/province/11111111111111111111111111111111")
                .then().log().all()
                .statusCode(200)
                .body("success", equalTo(false))
                .body("errorCode", equalTo(ErrorCode.Province_Not_Existed));
    }

    @Test
    public void test_get_province_cities() {
        givens().when().get(String.format("/zone/province/%s/cities", fujiansheng.getId()))
                .then().log().all()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("cities", hasSize(2));
    }
}
