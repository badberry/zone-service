package cn.cloudtop.zone.controllers.country;

import cn.cloudtop.strawberry.rest.RestResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by jackie on 16-4-22
 */
@ApiModel
public class CountriesGetResponse extends RestResponse {

    @ApiModelProperty("国家列表集合")
    public List<CountryDetailVo> countries;

    protected CountriesGetResponse() {

    }

    public CountriesGetResponse(List<CountryDetailVo> countries) {
        this.countries = countries;
    }

    public List<CountryDetailVo> getCountries() {
        return countries;
    }
}
