package cn.cloudtop.zone.controllers.province;

import cn.cloudtop.basic.RestResponse;
import io.swagger.annotations.ApiModel;

/**
 * Created by jackie on 16-5-16
 */
@ApiModel(value = "ProvinceGetResponse", description = "获取单个省份信息返回.")
public class ProvinceGetResponse extends RestResponse {

    private ProvinceDetailVo province;

    public ProvinceGetResponse(ProvinceDetailVo province) {
        this.province = province;
    }

    public ProvinceDetailVo getProvince() {
        return province;
    }
}
