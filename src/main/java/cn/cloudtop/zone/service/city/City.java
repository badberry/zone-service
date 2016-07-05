package cn.cloudtop.zone.service.city;

import cn.cloudtop.zone.controllers.city.CityDetailVo;
import cn.cloudtop.zone.service.Zone;
import cn.cloudtop.zone.service.districtCountry.DistrictCountry;
import cn.cloudtop.zone.service.province.Province;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jackie on 16-5-13
 */
@Entity
public class City extends Zone {

    private String mergeName;
    private String cityCode;
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provinceId")
    private Province province;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<DistrictCountry> districtCountries;

    public City() {
    }

    public City(String name, String shortName, String lng, String lat, String pinyin,
                String mergeName, String cityCode, String zipCode, Province province) {
        super(name, shortName, lng, lat, pinyin);
        this.mergeName = mergeName;
        this.cityCode = cityCode;
        this.zipCode = zipCode;
        this.province = province;
    }

    public String getMergeName() {
        return mergeName;
    }

    public void setMergeName(String mergeName) {
        this.mergeName = mergeName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<DistrictCountry> getDistrictCountries() {
        return districtCountries;
    }

    public void setDistrictCountries(List<DistrictCountry> districtCountries) {
        this.districtCountries = districtCountries;
    }

    public CityDetailVo toDetailVo() {
        return new CityDetailVo(this.getId(), this.getName(), this.getShortName(), this.getLng(),
                this.getLat(), this.getPinyin(), this.getMergeName(), this.getCityCode(), this.getZipCode(),
                this.province.getId(), this.province.getName());
    }
}
