package cn.cloudtop.zone.exceptions;

import cn.cloudtop.basic.RestException;

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
