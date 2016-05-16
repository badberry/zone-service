package cn.cloudtop.zone.controllers.country;

import cn.cloudtop.basic.RestResponse;
import cn.cloudtop.zone.controllers.province.ProvinceDetailVo;

import java.util.List;

/**
 * Created by jackie on 16-5-16
 */
public class CountryProvinceGetResponse extends RestResponse {

    private List<ProvinceDetailVo> provinces;

    public CountryProvinceGetResponse(List<ProvinceDetailVo> provinces) {
        this.provinces = provinces;
    }

    public List<ProvinceDetailVo> getProvinces() {
        return provinces;
    }
}
