package cn.cloudtop.zone.controllers.districtCountry;

import cn.cloudtop.strawberry.rest.RestException;
import cn.cloudtop.zone.controllers.ErrorCode;

/**
 * Created by jackie on 16-5-18
 */
public class DistrictCountryNotExistsException extends RestException {


    private String id;

    public DistrictCountryNotExistsException(String id) {
        super(ErrorCode.DistrictCountry_Not_Existed, "区县不存在!");
        this.id = id;
    }


    @Override
    public String getDebugMessage() {
        return String.format("districtCountry[%s] is not exists", this.id);
    }
}
