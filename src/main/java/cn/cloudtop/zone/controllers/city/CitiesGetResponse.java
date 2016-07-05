package cn.cloudtop.zone.controllers.city;

import cn.cloudtop.basic.RestResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by jackie on 16-5-17
 */
@ApiModel(value = "CitiesGetResponse", description = "获取所有城市返回")
public class CitiesGetResponse extends RestResponse {

    @ApiModelProperty("所有城市集合")
    private List<CityDetailVo> cities;

    public CitiesGetResponse(List<CityDetailVo> cities) {
        this.cities = cities;
    }

    public List<CityDetailVo> getCities() {
        return cities;
    }
}
