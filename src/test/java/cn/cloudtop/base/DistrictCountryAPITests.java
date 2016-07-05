package cn.cloudtop.base;

import cn.cloudtop.zone.ZoneServiceApplication;
import cn.cloudtop.zone.controllers.districtCountry.DistrictCountryVo;
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
 * Created by jackie on 16-5-18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ZoneServiceApplication.class)
@WebAppConfiguration
@IntegrationTest
public class DistrictCountryAPITests extends TestBase {
    @Test
    public void test_get_districtCountries() {
        given().
                log().all().
                when()
                .get("/zone/districtCountry")
                .then()
                .log().all()
                .statusCode(200)
                .body("districtCountries.pinyin", hasItems("Jimei", "Siming"))
                .body("districtCountries.id", hasSize(2));
    }

    @Test
    public void test_create_districtCountry() {
        given().log().all()
                .header("Content-Type", "application/json;charset=utf-8")
                .body(new DistrictCountryVo("湖里区", "湖里", "Huli", "118.14621", "24.51253", "361006", xiamen.getId()))
                .when().post("/zone/districtCountry")
                .then().log().all()
                .statusCode(200)
                .body("districtCountry.id", notNullValue())
                .body("districtCountry.name", equalTo("湖里区"))
                .body("districtCountry.pinyin", equalTo("Huli"));
    }

    private RequestSpecification givens() {
        return given().log().all().header("Content-Type", "application/json;charset=utf-8");
    }

    @Test
    public void test_get_districtCountry() {
        given().log().all().header("Content-Type", "application/json;charset=utf-8")
                .when().get("/zone/districtCountry/" + jimeiqu.getId())
                .then().log().all()
                .statusCode(200)
                .body("districtCountry.id", notNullValue())
                .body("districtCountry.id", equalTo(jimeiqu.getId()));
    }

    @Test
    public void test_get_districtCountry_throw_districtCountry_not_exists_exception() {
        givens().when().get("/zone/districtCountry/11111111111111111111111111111111")
                .then().log().all()
                .statusCode(200)
                .body("success", equalTo(false))
                .body("errorCode", equalTo(ErrorCode.DistrictCountry_Not_Existed));
    }
}
