package cn.cloudtop.zone.controllers.province;

import cn.cloudtop.basic.ChildMoreInfo;
import cn.cloudtop.zone.controllers.ZoneDetailVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-5-16
 */
@ApiModel(value = "ProvinceDetailVo", description = "省份信息")
public class ProvinceDetailVo extends ZoneDetailVo {

    @ApiModelProperty("全名称")
    private String mergeName;
    @ApiModelProperty("所属国家id")
    private String countryId;
    @ApiModelProperty("所属国家名称")
    private String countryName;
    @ApiModelProperty("获取所有城市方法")
    private ChildMoreInfo cities;

    public ProvinceDetailVo(String id, String name, String shortName,
                            String lng, String lat, String pinyin, String mergeName,
                            String countryId, String countryName) {
        super(id, name, shortName, lng, lat, pinyin);
        this.mergeName = mergeName;
        this.countryId = countryId;
        this.countryName = countryName;
        this.cities = new ChildMoreInfo("zoneService", String.format("/province/%s/cities", id));
    }

    public String getMergeName() {
        return mergeName;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public ChildMoreInfo getCities() {
        return cities;
    }
}
