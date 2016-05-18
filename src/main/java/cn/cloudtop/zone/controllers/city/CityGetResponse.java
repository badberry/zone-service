package cn.cloudtop.zone.controllers.city;

import cn.cloudtop.basic.RestResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-5-17
 */
@ApiModel(value = "CityGetResponse", description = "获取城市信息返回")
public class CityGetResponse extends RestResponse {

    @ApiModelProperty("城市详细信息")
    private CityDetailVo city;

    public CityGetResponse(CityDetailVo city) {
        this.city = city;
    }

    public CityDetailVo getCity() {
        return city;
    }
}
