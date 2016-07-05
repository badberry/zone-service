package cn.cloudtop.zone.init;

import cn.cloudtop.zone.service.city.City;
import cn.cloudtop.zone.service.country.Country;
import cn.cloudtop.zone.service.districtCountry.DistrictCountry;
import cn.cloudtop.zone.service.province.Province;

/**
 * 地域
 */
public class Area {

    private int id;
    private String name;
    private int parentId;
    private String shortName;
    private int levelType;
    private String cityCode;
    private String zipCode;
    private String mergeName;
    private String lng;
    private String lat;
    private String pinyin;

    /**
     * 构造函数
     */
    public Area() {
    }

    public Area(int id, String name, int parentId, String shortName, int levelType,
                String cityCode, String zipCode, String mergeName, String lng, String lat, String pinyin) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.shortName = shortName;
        this.levelType = levelType;
        this.cityCode = cityCode;
        this.zipCode = zipCode;
        this.mergeName = mergeName;
        this.lng = lng;
        this.lat = lat;
        this.pinyin = pinyin;
    }

    /**
     * get/set
     */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getParentId() {
        return parentId;
    }

    public String getShortName() {
        return shortName;
    }

    public int getLevelType() {
        return levelType;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getMergeName() {
        return mergeName;
    }

    public String getLng() {
        return lng;
    }

    public String getLat() {
        return lat;
    }

    public String getPinyin() {
        return pinyin;
    }

    public Country createCountry() {
        return new Country(this.name, this.shortName, this.lng, this.lat, this.pinyin);
    }

    public Province createProvince(Country country) {
        Province province = new Province();
        province.setName(this.name);
        province.setShortName(this.shortName);
        province.setMergeName(this.mergeName);
        province.setLat(this.lat);
        province.setLng(this.lng);
        province.setPinyin(this.pinyin);
        province.setCountry(country);
        return province;
    }

    public City createCity(Province province) {
        City city = new City();
        city.setCityCode(this.cityCode);
        city.setLat(this.lat);
        city.setLng(this.lng);
        city.setMergeName(this.mergeName);
        city.setName(this.name);
        city.setPinyin(this.pinyin);
        city.setShortName(this.shortName);
        city.setZipCode(this.zipCode);
        city.setProvince(province);
        return city;
    }

    public DistrictCountry createDistrictCountry(City city) {
        DistrictCountry district = new DistrictCountry();
        district.setLat(this.lat);
        district.setLng(this.lng);
        district.setMergeName(this.mergeName);
        district.setName(this.name);
        district.setPinyin(this.pinyin);
        district.setShortName(this.shortName);
        district.setZipCode(this.zipCode);
        district.setCity(city);
        return district;
    }
}
