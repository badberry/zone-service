package cn.cloudtop.zone.service.country;

import cn.cloudtop.zone.controllers.country.CountryDetailVo;
import cn.cloudtop.zone.service.Zone;
import cn.cloudtop.zone.service.province.Province;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jackie on 16-4-22
 */
@Entity
public class Country extends Zone {

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Province> provinces;

    public Country() {
    }

    public Country(String name, String shortName, String lng, String lat, String pinyin) {
        super(name, shortName, lng, lat, pinyin);
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public CountryDetailVo toDetailVo() {
        return new CountryDetailVo(this.getId(), this.getName(), this.getShortName(), this.getLng(),
                this.getLat(), this.getPinyin());
    }
}
