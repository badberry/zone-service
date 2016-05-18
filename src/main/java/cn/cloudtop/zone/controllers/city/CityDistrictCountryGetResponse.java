package cn.cloudtop.zone.controllers.city;

import cn.cloudtop.basic.RestResponse;
import cn.cloudtop.zone.controllers.districtCountry.DistrictCountryDetailVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by jackie on 16-5-17
 */
@ApiModel(value = "CityDistrictCountryGetResponse", description = "获取城市的所有区县信息返回")
public class CityDistrictCountryGetResponse extends RestResponse {

    @ApiModelProperty("所有区县信息集合")
    private List<DistrictCountryDetailVo> districtCountries;

    public CityDistrictCountryGetResponse(List<DistrictCountryDetailVo> districtCountries) {
        this.districtCountries = districtCountries;
    }

    public List<DistrictCountryDetailVo> getDistrictCountries() {
        return districtCountries;
    }
}
