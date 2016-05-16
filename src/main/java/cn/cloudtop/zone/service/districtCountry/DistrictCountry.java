package cn.cloudtop.zone.service.districtCountry;

import cn.cloudtop.zone.service.Zone;
import cn.cloudtop.zone.service.city.City;

import javax.persistence.*;

/**
 * Created by jackie on 16-5-13
 * <p>
 * 区县
 */
@Entity
public class DistrictCountry extends Zone {

    private String mergeName;
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cityId")
    private City city;

    public DistrictCountry() {

    }

    public DistrictCountry(String name, String shortName, String lng, String lat, String pinyin,
                           String mergeName, String zipCode, City city) {
        super(name, shortName, lng, lat, pinyin);
        this.mergeName = mergeName;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getMergeName() {
        return mergeName;
    }

    public void setMergeName(String mergeName) {
        this.mergeName = mergeName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
