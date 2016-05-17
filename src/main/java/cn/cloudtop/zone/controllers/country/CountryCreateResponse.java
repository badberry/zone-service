package cn.cloudtop.zone.controllers.country;

import cn.cloudtop.basic.RestResponse;
import cn.cloudtop.zone.service.country.Country;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-4-24
 */
@ApiModel
public class CountryCreateResponse extends RestResponse {

    @ApiModelProperty("创建好的国家")
    private CountryDetailVo country;

    public CountryCreateResponse(CountryDetailVo country) {
        this.country = country;
    }

    public CountryDetailVo getCountry() {
        return country;
    }
}
