package cn.cloudtop.zone.controllers.province;

import cn.cloudtop.strawberry.rest.RestResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by jackie on 16-5-16
 */
@ApiModel(value = "ProvincesGetResponse",description = "获取所有省份信息返回")
public class ProvincesGetResponse extends RestResponse {

    @ApiModelProperty("所有城市集合")
    private List<ProvinceDetailVo> provinces;

    public ProvincesGetResponse(List<ProvinceDetailVo> provinces){
        this.provinces = provinces;
    }

    public List<ProvinceDetailVo> getProvinces() {
        return provinces;
    }
}
