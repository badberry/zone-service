package cn.cloudtop.zone.controllers.districtCountry;

import cn.cloudtop.zone.controllers.city.CityNotExistsException;
import cn.cloudtop.zone.service.city.City;
import cn.cloudtop.zone.service.city.CityRepository;
import cn.cloudtop.zone.service.districtCountry.DistrictCountry;
import cn.cloudtop.zone.service.districtCountry.DistrictCountryRepository;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jackie on 16-5-18
 */
@RestController
@RequestMapping("zone/districtCountry")
public class DistrictCountryController {

    @Autowired
    private DistrictCountryRepository districtCountryRepository;
    @Autowired
    private CityRepository cityRepository;

    @ApiOperation(value = "获取所有区县", notes = "获取所有区县")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public DistrictCountriesGetResponse get() {
        List<DistrictCountry> districtCountries = Lists.newArrayList(districtCountryRepository.findAll());
        List<DistrictCountryDetailVo> districtCountryDetailVos = Lists.newArrayList();
        for (DistrictCountry districtCountry : districtCountries) {
            districtCountryDetailVos.add(districtCountry.toDetailVo());
        }
        return new DistrictCountriesGetResponse(districtCountryDetailVos);
    }

    @ApiOperation(value = "创建区县", notes = "创建区县")
    @ApiImplicitParam(name = "districtCountry", value = "区县信息", required = true, paramType = "body", dataType = "CountryVo")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public DistrictCountryCreateResponse create(@Valid @RequestBody DistrictCountryVo districtCountry) {
        if (!cityRepository.exists(districtCountry.getCityId())) {
            throw new CityNotExistsException(districtCountry.getCityId());
        }
        City city = cityRepository.getOne(districtCountry.getCityId());
        DistrictCountry districtCountryEntiry = new DistrictCountry(districtCountry.getName(), districtCountry.getShortName(),
                districtCountry.getLng(), districtCountry.getLat(), districtCountry.getPinyin(),
                String.format("%s,%s", city.getMergeName(), districtCountry.getName()), districtCountry.getZipCode(), city);
        districtCountryRepository.save(districtCountryEntiry);
        return new DistrictCountryCreateResponse(districtCountryEntiry.toDetailVo());
    }

    @ApiOperation(value = "获取区县信息", notes = "根据给定id获取区县信息")
    @ApiImplicitParam(name = "id", value = "区县id(32位字符串)", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public DistrictCountryGetResponse get(@PathVariable("id") String id) {
        if (!districtCountryRepository.exists(id)) {
            throw new DistrictCountryNotExistsException(id);
        }
        DistrictCountry districtCountry = districtCountryRepository.getOne(id);
        return new DistrictCountryGetResponse(districtCountry.toDetailVo());
    }

    @ApiOperation(value = "删除区县信息", notes = "删除指定id的区县信息")
    @ApiImplicitParam(name = "id", value = "区县(32位字符串)", required = true, paramType = "path", dataType = "string")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    public DistrictCountryDeleteResponse delete(@PathVariable("id") String id) {
        if (!districtCountryRepository.exists(id)) {
            throw new DistrictCountryNotExistsException(id);
        }
        districtCountryRepository.delete(id);
        return new DistrictCountryDeleteResponse();
    }
}
