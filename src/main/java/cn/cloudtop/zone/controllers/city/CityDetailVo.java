package cn.cloudtop.zone.controllers.city;

import cn.cloudtop.strawberry.rest.ChildMore;
import cn.cloudtop.zone.controllers.ZoneDetailVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-5-16
 */
@ApiModel(value = "CityDetailVo",description = "城市详细信息")
public class CityDetailVo extends ZoneDetailVo {

    @ApiModelProperty("全名称")
    private String mergeName;
    @ApiModelProperty("区号")
    private String cityCode;
    @ApiModelProperty("邮政编码")
    private String zipCode;
    @ApiModelProperty("所属省份Id")
    private String provinceId;
    @ApiModelProperty("所属省份名称")
    private String provinceName;
    @ApiModelProperty("获取当前城市的所有区县信息")
    private ChildMore districtCountries;

    public CityDetailVo(String id, String name, String shortName, String lng, String lat,
                        String pinyin, String mergeName, String cityCode, String zipCode,
                        String provinceId, String provinceName) {
        super(id, name, shortName, lng, lat, pinyin);
        this.mergeName = mergeName;
        this.cityCode = cityCode;
        this.zipCode = zipCode;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.districtCountries = new ChildMore("zoneService",
                String.format("/city/%s/districtCountries", id));
    }

    public String getMergeName() {
        return mergeName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public ChildMore getDistrictCountries() {
        return districtCountries;
    }
}
