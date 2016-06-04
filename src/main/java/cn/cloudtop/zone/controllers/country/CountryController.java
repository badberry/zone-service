package cn.cloudtop.zone.controllers.country;

import cn.cloudtop.zone.controllers.province.ProvinceDetailVo;
import cn.cloudtop.zone.exceptions.CountryNotExistsException;
import cn.cloudtop.zone.service.country.Country;
import cn.cloudtop.zone.service.country.CountryRepository;
import cn.cloudtop.zone.service.province.Province;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jackie on 16-4-22
 */
@RestController
@RequestMapping("zone/country")
@Api(value = "CountryController", description = "国家接口")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @ApiOperation(value = "获取所有国家", notes = "获取所有国家")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public CountriesGetResponse get() {
        List<Country> countries = Lists.newArrayList(countryRepository.findAll());
        List<CountryDetailVo> countryDetailVos = Lists.newArrayList();
        for (Country country : countries) {
            countryDetailVos.add(country.toDetailVo());
        }
        return new CountriesGetResponse(countryDetailVos);
    }

    @ApiOperation(value = "创建国家信息", notes = "创建国家信息")
    @ApiImplicitParam(name = "country", value = "国家信息", required = true, paramType = "body", dataType = "CountryVo")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public CountryCreateResponse create(@Valid @RequestBody CountryVo country) {
        Country countryEntity = new Country(country.getName(), country.getShortName(),
                country.getLng(), country.getLat(), country.getPinyin());
        countryRepository.save(countryEntity);
        return new CountryCreateResponse(countryEntity.toDetailVo());
    }

    @ApiOperation(value = "获取国家信息", notes = "根据给定id获取国家信息")
    @ApiImplicitParam(name = "id", value = "国家id(32位字符串)", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public CountryGetResponse get(@PathVariable("id") String id) {
        if (!countryRepository.exists(id)) {
            throw new CountryNotExistsException(id);
        }
        Country country = countryRepository.findOne(id);
        return new CountryGetResponse(country.toDetailVo());
    }

    @ApiOperation(value = "删除国家信息", notes = "删除指定id的国家信息")
    @ApiImplicitParam(name = "id", value = "国家id(32位字符串)", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    public CountryDeleteResponse delete(@PathVariable("id") String id) {
        if (!countryRepository.exists(id)) {
            throw new CountryNotExistsException(id);
        }
        countryRepository.delete(id);
        return new CountryDeleteResponse();
    }

    @ApiOperation(value = "获取国家的所有省份信息", notes = "获取指定国家的所有省份信息.")
    @ApiImplicitParam(name = "id", value = "国家id(32位字符串)", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "{id}/provinces", method = RequestMethod.GET, produces = "application/json")
    public CountryProvinceGetResponse provinces(@PathVariable("id") String id) {
        if (!countryRepository.exists(id)) {
            throw new CountryNotExistsException(id);
        }
        Country country = countryRepository.getOne(id);
        List<ProvinceDetailVo> provinceVos = Lists.newArrayList();
        for (Province province : country.getProvinces()) {
            provinceVos.add(province.toDetailVo());
        }
        return new CountryProvinceGetResponse(provinceVos);
    }
}
