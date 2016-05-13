package cn.cloudtop.zone.controllers.country;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-5-13
 */
public abstract class ZoneDetailVo {
    @ApiModelProperty("唯一标识符")
    private String id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("缩写")
    private String shortName;
    @ApiModelProperty("经度")
    private String lng;
    @ApiModelProperty("纬度")
    private String lat;
    @ApiModelProperty("拼音")
    private String pinyin;

    public ZoneDetailVo(String id, String name, String shortName, String lng, String lat, String pinyin) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.lng = lng;
        this.lat = lat;
        this.pinyin = pinyin;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLng() {
        return lng;
    }

    public String getLat() {
        return lat;
    }

    public String getPinyin() {
        return pinyin;
    }
}
