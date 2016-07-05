package cn.cloudtop.zone.controllers.city;

import cn.cloudtop.strawberry.rest.RestException;
import cn.cloudtop.zone.controllers.ErrorCode;

/**
 * Created by jackie on 16-5-17
 */
public class CityNotExistsException extends RestException {

    private String id;

    public CityNotExistsException(String id) {
        super(ErrorCode.City_Not_Existed, "城市不存在!");
        this.id = id;
    }


    @Override
    public String getDebugMessage() {
        return String.format("city[%s] is not exists", this.id);
    }
}
