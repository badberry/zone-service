package cn.cloudtop.zone.controllers.country;

import cn.cloudtop.strawberry.rest.RestResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-4-26
 */
@ApiModel
public class CountryGetResponse extends RestResponse {

    @ApiModelProperty("国家信息")
    private CountryDetailVo country;

    protected CountryGetResponse() {
    }

    public CountryGetResponse(CountryDetailVo country) {
        this.country = country;
    }

    public CountryDetailVo getCountry() {
        return country;
    }
}
