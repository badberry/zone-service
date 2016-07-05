package cn.cloudtop.zone.controllers.province;

import cn.cloudtop.basic.RestResponse;
import cn.cloudtop.zone.controllers.city.CityDetailVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by jackie on 16-5-16
 */
@ApiModel(value = "ProvinceCityGetResponse", description = "获取省份城市返回")
public class ProvinceCityGetResponse extends RestResponse {

    @ApiModelProperty("所有城市信息")
    private List<CityDetailVo> cities;

    public ProvinceCityGetResponse(List<CityDetailVo> cities) {
        this.cities = cities;
    }

    public List<CityDetailVo> getCities() {
        return cities;
    }
}
