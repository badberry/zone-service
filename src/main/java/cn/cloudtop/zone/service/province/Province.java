package cn.cloudtop.zone.service.province;

import cn.cloudtop.zone.controllers.province.ProvinceDetailVo;
import cn.cloudtop.zone.service.Zone;
import cn.cloudtop.zone.service.city.City;
import cn.cloudtop.zone.service.country.Country;
import cn.cloudtop.zone.service.districtCountry.DistrictCountry;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jackie on 16-4-22
 * <p>
 * 省.
 */
@Entity
public class Province extends Zone {

    private String mergeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId")
    public Country country;

    @OneToMany(mappedBy = "province", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<City> cities;

    public Province() {
    }

    public Province(String name, String shortName, String lng, String lat, String pinyin,
                    String mergeName, Country country) {
        super(name, shortName, lng, lat, pinyin);
        this.mergeName = mergeName;
        this.country = country;
    }

    public String getMergeName() {
        return mergeName;
    }

    public void setMergeName(String mergeName) {
        this.mergeName = mergeName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public ProvinceDetailVo toDetailVo() {
        return new ProvinceDetailVo(this.getId(), this.getName(), this.getShortName(),
                this.getLng(), this.getLat(), this.getPinyin(), this.getMergeName(),
                this.country.getId(), this.country.getName());
    }
}
