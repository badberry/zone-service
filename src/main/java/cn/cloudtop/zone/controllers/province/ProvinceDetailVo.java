package cn.cloudtop.zone.controllers.province;

import cn.cloudtop.basic.ChildMoreInfo;
import cn.cloudtop.zone.controllers.ZoneDetailVo;
import io.swagger.annotations.ApiModel;

/**
 * Created by jackie on 16-5-16
 */
@ApiModel
public class ProvinceDetailVo extends ZoneDetailVo {

    private String mergeName;
    private String countryId;
    private String countryName;
    private ChildMoreInfo cities;

    public ProvinceDetailVo(String id, String name, String shortName,
                            String lng, String lat, String pinyin, String mergeName,
                            String countryId, String countryName) {
        super(id, name, shortName, lng, lat, pinyin);
        this.mergeName = mergeName;
        this.countryId = countryId;
        this.countryName = countryName;
        this.cities = new ChildMoreInfo("zoneService", String.format("/province/%s/cities", id));
    }

    public String getMergeName() {
        return mergeName;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public ChildMoreInfo getCities() {
        return cities;
    }
}
