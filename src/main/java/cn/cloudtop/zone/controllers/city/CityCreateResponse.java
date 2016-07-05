package cn.cloudtop.zone.controllers.city;

import cn.cloudtop.basic.RestResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-5-17
 */
@ApiModel(value = "CityCreateResponse", description = "创建城市信息返回")
public class CityCreateResponse extends RestResponse {

    @ApiModelProperty("创建的城市信息")
    private CityDetailVo city;

    public CityCreateResponse(CityDetailVo city) {
        this.city = city;
    }

    public CityDetailVo getCity() {
        return city;
    }
}
