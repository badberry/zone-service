package cn.cloudtop.zone.controllers.districtCountry;

import cn.cloudtop.zone.Regex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Created by jackie on 16-5-18
 */
@ApiModel(value = "DistrictCountryVo", description = "区县创建所需信息")
public class DistrictCountryVo {

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

    @ApiModelProperty("邮政编码")
    @NotEmpty(message = "邮政编码必须输入")
    @Pattern(regexp = Regex.Zip_Code, message = "邮政编码格式不正确,开头不能为0,共6位数字")
    private String zipCode;

    @ApiModelProperty("所属城市Id")
    @NotEmpty(message = "所属城市Id必须输入")
    @Length(max = 32, min = 32, message = "城市Id的长度为32位字符串")
    private String cityId;

    public DistrictCountryVo() {
    }

    public DistrictCountryVo(String name, String shortName, String pinyin,
                             String lng, String lat, String zipCode, String cityId) {
        this.name = name;
        this.shortName = shortName;
        this.pinyin = pinyin;
        this.lng = lng;
        this.lat = lat;
        this.zipCode = zipCode;
        this.cityId = cityId;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
