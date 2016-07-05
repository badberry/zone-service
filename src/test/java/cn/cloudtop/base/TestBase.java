package cn.cloudtop.base;

import cn.cloudtop.zone.service.city.City;
import cn.cloudtop.zone.service.city.CityRepository;
import cn.cloudtop.zone.service.country.Country;
import cn.cloudtop.zone.service.country.CountryRepository;
import cn.cloudtop.zone.service.districtCountry.DistrictCountry;
import cn.cloudtop.zone.service.districtCountry.DistrictCountryRepository;
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
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private DistrictCountryRepository districtCountryRepository;

    protected Country china;
    protected Country usa;

    @Before
    public void setUp() {
        deleteDistrictCountry();
        deleteCity();
        deleteProvince();
        deleteCountry();

        initCountry();
        initProvince();
        initCity();
        initDistrictCountry();
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

    private void initProvince() {
        beijing = new Province("北京", "北京", "116.405285", "39.904989", "Beijing", "中国,北京", china);
        fujiansheng = new Province("福建省", "福建", "119.306239", "26.075302", "Fujian", "中国,福建省", china);

        provinceRepository.save(Lists.newArrayList(beijing, fujiansheng));
    }

    private void deleteProvince() {
        provinceRepository.deleteAllInBatch();
    }

    protected City fuzhou;
    protected City xiamen;

    private void initCity() {
        fuzhou = new City("福州市", "福州", "119.306239", "26.075302", "Fuzhou", "中国,福建省,福州市", "0591", "350001", fujiansheng);
        xiamen = new City("厦门市", "厦门", "118.11022", "24.490474", "Xiamen", "中国,福建省,厦门市", "0592", "361003", fujiansheng);
        cityRepository.save(Lists.newArrayList(fuzhou, xiamen));
    }

    private void deleteCity() {
        cityRepository.deleteAllInBatch();
    }

    protected DistrictCountry jimeiqu;
    protected DistrictCountry simingqu;

    private void initDistrictCountry() {
        jimeiqu = new DistrictCountry("集美区", "集美", "118.09719", "24.57584", "Jimei", "中国,福建省,厦门市,集美区", "361021", xiamen);
        simingqu = new DistrictCountry("思明区", "思明", "118.08233", "24.44543", "Siming", "中国,福建省,厦门市,思明区", "361001", xiamen);
        districtCountryRepository.save(Lists.newArrayList(jimeiqu, simingqu));
    }

    private void deleteDistrictCountry() {
        districtCountryRepository.deleteAllInBatch();
    }
}
