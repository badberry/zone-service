package cn.cloudtop.zone.controllers.districtCountry;

import cn.cloudtop.strawberry.rest.RestResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-5-18
 */
@ApiModel(value = "DistrictCountryGetResponse", description = "获取区县信息返回")
public class DistrictCountryGetResponse extends RestResponse {

    @ApiModelProperty("区县详细信息")
    private DistrictCountryDetailVo districtCountry;

    public DistrictCountryGetResponse(DistrictCountryDetailVo districtCountry) {
        this.districtCountry = districtCountry;
    }

    public DistrictCountryDetailVo getDistrictCountry() {
        return districtCountry;
    }
}
