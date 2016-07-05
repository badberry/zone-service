package cn.cloudtop.zone.init;

import cn.cloudtop.zone.ZoneServiceApplication;
import cn.cloudtop.zone.service.city.City;
import cn.cloudtop.zone.service.city.CityRepository;
import cn.cloudtop.zone.service.country.Country;
import cn.cloudtop.zone.service.country.CountryRepository;
import cn.cloudtop.zone.service.districtCountry.DistrictCountry;
import cn.cloudtop.zone.service.districtCountry.DistrictCountryRepository;
import cn.cloudtop.zone.service.province.Province;
import cn.cloudtop.zone.service.province.ProvinceRepository;
import com.google.common.collect.Lists;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jackie on 16-6-22
 */
@Order(1)
@Component
public class InitializeChinesZone implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitializeChinesZone.class);

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private DistrictCountryRepository districtCountryRepository;
    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("init chinese zone start");
        if (countryRepository.findAll().size() == 0) {
            Map<Integer, List<Area>> areaMap = loadArea();
            List<Area> countries = areaMap.get(0);
            List<Area> provinces = areaMap.get(1);
            List<Area> cities = areaMap.get(2);
            List<Area> districts = areaMap.get(3);
            for (Area area : countries) {
                Country country = area.createCountry();
                countryRepository.save(country);
                List<Area> countryProvinces = getChilds(provinces, area.getId());
                for (Area provinceArea : countryProvinces) {
                    Province province = provinceArea.createProvince(country);
                    provinceRepository.save(province);
                    List<Area> provinceCities = getChilds(cities, provinceArea.getId());
                    for (Area provinceCity : provinceCities) {
                        City city = provinceCity.createCity(province);
                        cityRepository.save(city);
                        List<Area> cityDistricts = getChilds(districts, provinceCity.getId());
                        for (Area cityDistrict : cityDistricts) {
                            DistrictCountry district = cityDistrict.createDistrictCountry(city);
                            districtCountryRepository.save(district);
                        }
                    }

                }
            }
        }
        LOGGER.info("init chinese zone finished.");
    }

    private List<Area> getChilds(List<Area> collection, int parentId) {
        List<Area> childArray = Lists.newArrayList();
        for (Area child : collection) {
            if (child.getParentId() == parentId) {
                childArray.add(child);
            }
        }
        return childArray;
    }

    /**
     * 读取excel的地域信息
     *
     * @return
     * @throws IOException
     * @throws BiffException
     */
    private Map<Integer, List<Area>> loadArea() throws IOException, BiffException {
        InputStream zoneResorce = resourceLoader.getResource("classpath:chinese.xls").getInputStream();
        Workbook workbook = Workbook.getWorkbook(zoneResorce);
        Map<Integer, List<Area>> areaMap = new HashMap<Integer, List<Area>>();
        Sheet sheet = workbook.getSheet(0);
        for (int i = 1; i < sheet.getRows(); i++) {
            int id = Integer.parseInt(sheet.getCell(0, i).getContents());
            String name = sheet.getCell(1, i).getContents();
            int parentId = Integer.parseInt(sheet.getCell(2, i).getContents());
            String shortName = sheet.getCell(3, i).getContents();
            int levelType = Integer.parseInt(sheet.getCell(4, i).getContents());
            String cityCode = sheet.getCell(5, i).getContents();
            String zipCode = sheet.getCell(6, i).getContents();
            String mergerName = sheet.getCell(7, i).getContents();
            String lng = sheet.getCell(8, i).getContents();
            String lat = sheet.getCell(9, i).getContents();
            String pinyin = sheet.getCell(10, i).getContents();
            Area area = new Area(id, name, parentId, shortName, levelType, cityCode, zipCode,
                    mergerName, lng, lat, pinyin);
            if (areaMap.containsKey(area.getLevelType())) {
                List<Area> areas = areaMap.get(area.getLevelType());
                areas.add(area);
            } else {
                List<Area> areas = new ArrayList<Area>();
                areas.add(area);
                areaMap.put(area.getLevelType(), areas);
            }
        }
        return areaMap;
    }
}
