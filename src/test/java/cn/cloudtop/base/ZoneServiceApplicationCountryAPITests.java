package cn.cloudtop.base;

import cn.cloudtop.zone.ZoneServiceApplication;
import cn.cloudtop.zone.controllers.country.CountryVo;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ZoneServiceApplication.class)
@WebAppConfiguration
@IntegrationTest
public class ZoneServiceApplicationCountryAPITests extends TestBase {

    @Test
    public void test_get_countries() {
        given().
                log().all().
                when()
                .get("/zone/country")
                .then()
                .log().all()
                .statusCode(200)
                .body("countries.pinyin", hasItems("China", "USA"))
                .body("countries.id", hasSize(2));
    }

    @Test
    public void test_create_country() {
        given().log().all()
                .header("Content-Type", "application/json;charset=utf-8")
                .body(new CountryVo("印度", "印度", "India", "39.915085", "39.915085"))
                .when().post("/zone/country")
                .then().log().all()
                .statusCode(200)
                .body("country.id", notNullValue())
                .body("country.name", equalTo("印度"))
                .body("country.pinyin", equalTo("India"));
    }

    private RequestSpecification givens() {
        return given().log().all().header("Content-Type", "application/json;charset=utf-8");
    }

    @Test
    public void test_get_country() {
        given().log().all().header("Content-Type", "application/json;charset=utf-8")
                .when().get("/zone/country/" + china.getId())
                .then().log().all()
                .statusCode(200)
                .body("country.id", notNullValue())
                .body("country.id", equalTo(china.getId()));
    }

    @Test
    public void test_get_country_throw_country_not_exists_exception() {
        givens().when().get("/zone/country/11111111111111111111111111111111")
                .then().log().all()
                .statusCode(200)
                .body("success", equalTo(false))
                .body("errorCode", equalTo(ErrorCode.Country_Not_Existed));
    }

    @Test
    public void test_get_country_provinces() {
        givens().when().get(String.format("/zone/country/%s/provinces", china.getId()))
                .then().log().all()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("provinces", hasSize(2));
    }
}
