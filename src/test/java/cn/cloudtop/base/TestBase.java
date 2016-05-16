package cn.cloudtop.base;

import cn.cloudtop.zone.service.country.Country;
import cn.cloudtop.zone.service.country.CountryRepository;
import cn.cloudtop.zone.service.province.Province;
import cn.cloudtop.zone.service.province.ProvinceRepository;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * Created by jackie on 16-5-16
 */
public abstract class TestBase {

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    protected Country china;
    protected Country usa;

    @Before
    public void setUp() {
        deleteProvince();
        deleteCountry();

        initCountry();
        initProvince();
    }

    private void initCountry() {
        china = new Country("中国", "中国", "116.3683244", "39.915085", "China");
        usa = new Country("美国", "美国", "116.3683244", "39.915085", "USA");
        countryRepository.save(Lists.newArrayList(china, usa));
    }

    private void deleteCountry() {
        countryRepository.deleteAllInBatch();
    }

    protected Province beijing;
    protected Province fujiansheng;

    public void initProvince() {
        beijing = new Province("北京", "北京", "116.405285", "39.904989", "Beijing", "中国,北京", china);
        fujiansheng = new Province("福建省", "福建", "119.306239", "26.075302", "Fujian", "中国,福建省", china);

        provinceRepository.save(Lists.newArrayList(beijing, fujiansheng));
    }

    public void deleteProvince() {
        provinceRepository.deleteAllInBatch();
    }
}
