package cn.cloudtop.zone.controllers.districtCountry;

import cn.cloudtop.basic.RestResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-5-18
 */
@ApiModel(value = "DistrictCountryCreateResponse", description = "创建区县返回")
public class DistrictCountryCreateResponse extends RestResponse {

    @ApiModelProperty("被创建的区县信息")
    private DistrictCountryDetailVo districtCountry;

    public DistrictCountryCreateResponse(DistrictCountryDetailVo districtCountry) {
        this.districtCountry = districtCountry;
    }

    public DistrictCountryDetailVo getDistrictCountry() {
        return districtCountry;
    }
}
