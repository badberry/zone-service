package cn.cloudtop.zone.controllers.districtCountry;

import cn.cloudtop.zone.controllers.ZoneDetailVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-5-17
 */
@ApiModel(value = "DistrictCountryDetailVo", description = "区县详细信息")
public class DistrictCountryDetailVo extends ZoneDetailVo {

    @ApiModelProperty("全名称")
    private String mergeName;
    @ApiModelProperty("邮政编码")
    private String zipCode;
    @ApiModelProperty("所属城市id")
    private String cityId;
    @ApiModelProperty("所属城市名称")
    private String cityName;

    public DistrictCountryDetailVo(String id, String name, String shortName, String lng, String lat, String pinyin,
                                   String mergeName, String zipCode, String cityId, String cityName) {
        super(id, name, shortName, lng, lat, pinyin);
        this.mergeName = mergeName;
        this.zipCode = zipCode;
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public String getMergeName() {
        return mergeName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }
}
