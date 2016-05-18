package cn.cloudtop.zone.controllers.city;

import cn.cloudtop.zone.controllers.districtCountry.DistrictCountryDetailVo;
import cn.cloudtop.zone.controllers.province.ProvinceNotExistsException;
import cn.cloudtop.zone.service.city.City;
import cn.cloudtop.zone.service.city.CityRepository;
import cn.cloudtop.zone.service.districtCountry.DistrictCountry;
import cn.cloudtop.zone.service.province.Province;
import cn.cloudtop.zone.service.province.ProvinceRepository;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jackie on 16-5-17
 */
@RestController
@RequestMapping("zone/city")
public class CityController {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    @ApiOperation(value = "获取所有城市", notes = "获取所有城市")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public CitiesGetResponse get() {
        List<City> cities = Lists.newArrayList(cityRepository.findAll());
        List<CityDetailVo> provinceDetailVos = Lists.newArrayList();
        for (City city : cities) {
            provinceDetailVos.add(city.toDetailVo());
        }
        return new CitiesGetResponse(provinceDetailVos);
    }

    @ApiOperation(value = "创建城市", notes = "创建城市")
    @ApiImplicitParam(name = "city", value = "城市信息", required = true, paramType = "body", dataType = "CountryVo")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public CityCreateResponse create(@Valid @RequestBody CityVo city) {
        if (!provinceRepository.exists(city.getProvinceId())) {
            throw new ProvinceNotExistsException(city.getProvinceId());
        }
        Province province = provinceRepository.getOne(city.getProvinceId());
        City cityEntity = new City(city.getName(), city.getShortName(), city.getLng(), city.getLat(),
                city.getPinyin(), String.format("%s,%s", province.getMergeName(), city.getName()),
                city.getCityCode(), city.getZipCode(), province);
        cityRepository.save(cityEntity);
        return new CityCreateResponse(cityEntity.toDetailVo());
    }

    @ApiOperation(value = "获取城市信息", notes = "根据给定id获取城市信息")
    @ApiImplicitParam(name = "id", value = "城市id(32位字符串)", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public CityGetResponse get(@PathVariable("id") String id) {
        if (!cityRepository.exists(id)) {
            throw new CityNotExistsException(id);
        }
        City city = cityRepository.getOne(id);
        return new CityGetResponse(city.toDetailVo());
    }

    @ApiOperation(value = "删除城市信息", notes = "删除指定id的城市信息")
    @ApiImplicitParam(name = "id", value = "城市(32位字符串)", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    public CityDeleteResponse delete(@PathVariable("id") String id) {
        if (!cityRepository.exists(id)) {
            throw new CityNotExistsException(id);
        }
        cityRepository.delete(id);
        return new CityDeleteResponse();
    }

    @ApiOperation(value = "获取城市的所有区县信息", notes = "获取指定城市的所有区县信息.")
    @ApiImplicitParam(name = "id", value = "城市id(32位字符串)", required = true, paramType = "path")
    @RequestMapping(value = "{id}/districtCounties", method = RequestMethod.GET, produces = "application/json")
    public CityDistrictCountryGetResponse provinces(@PathVariable("id") String id) {
        if (!cityRepository.exists(id)) {
            throw new CityNotExistsException(id);
        }
        City city = cityRepository.getOne(id);
        List<DistrictCountryDetailVo> districtCountryDetailVos = Lists.newArrayList();
        for (DistrictCountry districtCountry : city.getDistrictCountries()) {
            districtCountryDetailVos.add(districtCountry.toDetailVo());
        }
        return new CityDistrictCountryGetResponse(districtCountryDetailVos);
    }

}
