package cn.cloudtop.zone.controllers.province;

import cn.cloudtop.zone.Regex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Created by jackie on 16-5-16
 */
@ApiModel(value = "ProvinceVo", description = "创建省份所需要的信息")
public class ProvinceVo {
    @ApiModelProperty("名称")
    @NotEmpty(message = "名称必须输入")
    @Length(max = 50, message = "名称长度不能大于50个字符")
    private String name;

    @ApiModelProperty("缩写")
    @NotEmpty(message = "缩写必须输入")
    @Length(max = 20, message = "缩写长度不能大于50个字符")
    private String shortName;

    @ApiModelProperty("拼音")
    @NotEmpty(message = "拼音必须输入")
    @Length(max = 20, message = "拼音长度不能大于20个字符")
    private String pinyin;

    @ApiModelProperty("经度")
    @NotEmpty(message = "经度必须输入")
    @Pattern(regexp = Regex.Lng_Regex, message = "经度输入不正确")
    private String lng;

    @ApiModelProperty("纬度")
    @NotEmpty(message = "纬度必须输入")
    @Pattern(regexp = Regex.Lat_Regex, message = "纬度输入不正确")
    private String lat;

    @ApiModelProperty("所属国家Id")
    @NotEmpty(message = "所属国家必须输入")
    @Length(max = 32, min = 32, message = "国家Id的长度为32位字符串")
    private String countryId;

    public ProvinceVo() {

    }

    public ProvinceVo(String name, String shortName, String pinyin,
                      String lng, String lat, String countryId) {
        this.name = name;
        this.shortName = shortName;
        this.pinyin = pinyin;
        this.lng = lng;
        this.lat = lat;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}
