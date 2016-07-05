package cn.cloudtop.zone.controllers.province;

import cn.cloudtop.basic.RestResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-5-16
 */
@ApiModel(value = "ProvinceCreateResponse", description = "创建省份接口返回")
public class ProvinceCreateResponse extends RestResponse {

    @ApiModelProperty("创建好的省份信息")
    private ProvinceDetailVo province;

    public ProvinceCreateResponse(ProvinceDetailVo province) {
        this.province = province;
    }

    public ProvinceDetailVo getProvince() {
        return province;
    }
}
