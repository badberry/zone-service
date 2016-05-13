package cn.cloudtop.zone.service.province;

import cn.cloudtop.zone.service.Zone;
import cn.cloudtop.zone.service.country.Country;

import javax.persistence.*;

/**
 * Created by jackie on 16-4-22
 */
@Entity
public class Province extends Zone {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "countryId")
    public Country country;
}
