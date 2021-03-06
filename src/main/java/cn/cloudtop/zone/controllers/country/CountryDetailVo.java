package cn.cloudtop.zone.controllers.country;

import cn.cloudtop.strawberry.rest.ChildMore;
import cn.cloudtop.zone.controllers.ZoneDetailVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-5-13
 */
@ApiModel
public class CountryDetailVo extends ZoneDetailVo {

    @ApiModelProperty("获取当前国家的所有省份信息")
    private ChildMore provinces;

    protected CountryDetailVo() {
        super();
    }


    public CountryDetailVo(String id, String name, String shortName,
                           String lng, String lat, String pinyin) {
        super(id, name, shortName, lng, lat, pinyin);
        this.provinces = new ChildMore("zoneService", String.format("/country/%s/provinces", id));
    }

    public ChildMore getProvinces() {
        return provinces;
    }
}
