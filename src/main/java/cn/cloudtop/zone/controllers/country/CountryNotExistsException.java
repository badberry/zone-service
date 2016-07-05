package cn.cloudtop.zone.controllers.country;

import cn.cloudtop.strawberry.rest.RestException;
import cn.cloudtop.zone.controllers.ErrorCode;

/**
 * Created by jackie on 16-4-26
 */
public class CountryNotExistsException extends RestException {

    private String id;

    public CountryNotExistsException(String id) {
        super(ErrorCode.Country_Not_Existed, "国家不存在!");
        this.id = id;
    }

    @Override
    public String getDebugMessage() {
        return String.format("country[%s] is not exists", this.id);
    }
}
