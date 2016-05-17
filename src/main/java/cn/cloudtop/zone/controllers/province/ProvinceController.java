package cn.cloudtop.zone.controllers.province;

import cn.cloudtop.zone.controllers.city.CityDetailVo;
import cn.cloudtop.zone.exceptions.CountryNotExistsException;
import cn.cloudtop.zone.service.city.City;
import cn.cloudtop.zone.service.country.Country;
import cn.cloudtop.zone.service.country.CountryRepository;
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
 * Created by jackie on 16-5-13
 */
@RestController
@RequestMapping("zone/province")
public class ProvinceController {

    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private CountryRepository countryRepository;

    @ApiOperation(value = "获取所有省份", notes = "获取所有省份")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ProvincesGetResponse get() {
        List<Province> provinces = Lists.newArrayList(provinceRepository.findAll());
        List<ProvinceDetailVo> provinceDetailVos = Lists.newArrayList();
        for (Province country : provinces) {
            provinceDetailVos.add(country.toDetailVo());
        }
        return new ProvincesGetResponse(provinceDetailVos);
    }

    @ApiOperation(value = "创建省份", notes = "创建省份")
    @ApiImplicitParam(name = "province", value = "省份信息", required = true, paramType = "body", dataType = "CountryVo")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ProvinceCreateResponse create(@Valid @RequestBody ProvinceVo province) {
        if (!countryRepository.exists(province.getCountryId())) {
            throw new CountryNotExistsException(province.getCountryId());
        }
        Country country = countryRepository.getOne(province.getCountryId());
        Province provinceEntity = new Province(province.getName(), province.getShortName(), province.getLng(),
                province.getLat(), province.getPinyin(),
                String.format("%s,%s", country.getName(), province.getName()), country);
        provinceRepository.save(provinceEntity);
        return new ProvinceCreateResponse(provinceEntity.toDetailVo());
    }

    @ApiOperation(value = "获取省份信息", notes = "根据给定id获取省份信息")
    @ApiImplicitParam(name = "id", value = "省份id(32位字符串)", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public ProvinceGetResponse get(@PathVariable("id") String id) {
        if (!provinceRepository.exists(id)) {
            throw new ProvinceNotExistsException(id);
        }
        Province province = provinceRepository.getOne(id);
        return new ProvinceGetResponse(province.toDetailVo());
    }

    @ApiOperation(value = "删除省份信息", notes = "删除指定id的省份信息")
    @ApiImplicitParam(name = "id", value = "省份id(32位字符串)", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ProvinceDeleteResponse delete(@PathVariable("id") String id) {
        if (!provinceRepository.exists(id)) {
            throw new CountryNotExistsException(id);
        }
        provinceRepository.delete(id);
        return new ProvinceDeleteResponse();
    }

    @ApiOperation(value = "获取省份的所有城市信息", notes = "获取指定省份的所有城市信息.")
    @ApiImplicitParam(name = "id", value = "省份id(32位字符串)", required = true, paramType = "path")
    @RequestMapping(value = "{id}/cities", method = RequestMethod.GET, produces = "application/json")
    public ProvinceCityGetResponse provinces(@PathVariable("id") String id) {
        if (!provinceRepository.exists(id)) {
            throw new CountryNotExistsException(id);
        }
        Province province = provinceRepository.getOne(id);
        List<CityDetailVo> cityVos = Lists.newArrayList();
        for (City city : province.getCities()) {
            cityVos.add(city.toDetailVo());
        }
        return new ProvinceCityGetResponse(cityVos);
    }

}
