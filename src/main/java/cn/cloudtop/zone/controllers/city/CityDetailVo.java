package cn.cloudtop.zone.controllers.city;

import cn.cloudtop.basic.ChildMoreInfo;
import cn.cloudtop.zone.controllers.ZoneDetailVo;

/**
 * Created by jackie on 16-5-16
 */
public class CityDetailVo extends ZoneDetailVo {

    private String mergeName;
    private String cityCode;
    private String zipCode;
    private String provinceId;
    private String provinceName;
    private ChildMoreInfo districtCountries;

    public CityDetailVo(String id, String name, String shortName, String lng, String lat,
                        String pinyin, String mergeName, String cityCode, String zipCode,
                        String provinceId, String provinceName) {
        super(id, name, shortName, lng, lat, pinyin);
        this.mergeName = mergeName;
        this.cityCode = cityCode;
        this.zipCode = zipCode;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.districtCountries = new ChildMoreInfo("zoneService",
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

    public ChildMoreInfo getDistrictCountries() {
        return districtCountries;
    }
}
