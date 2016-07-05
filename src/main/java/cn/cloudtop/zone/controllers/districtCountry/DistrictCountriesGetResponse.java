package cn.cloudtop.zone.controllers.districtCountry;

import cn.cloudtop.strawberry.rest.RestResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by jackie on 16-5-18
 */
@ApiModel(value = "DistrictCountriesGetResponse", description = "获取所有区县返回")
public class DistrictCountriesGetResponse extends RestResponse {

    @ApiModelProperty("所有区县信息集合")
    private List<DistrictCountryDetailVo> districtCountries;

    public DistrictCountriesGetResponse(List<DistrictCountryDetailVo> districtCountries) {
        this.districtCountries = districtCountries;
    }

    public List<DistrictCountryDetailVo> getDistrictCountries() {
        return districtCountries;
    }
}
