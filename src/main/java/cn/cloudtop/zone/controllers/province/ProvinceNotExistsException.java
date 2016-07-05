package cn.cloudtop.zone.controllers.province;

import cn.cloudtop.strawberry.rest.RestException;
import cn.cloudtop.zone.controllers.ErrorCode;

/**
 * Created by jackie on 16-5-16
 */
public class ProvinceNotExistsException extends RestException {

    private String id;

    public ProvinceNotExistsException(String id) {
        super(ErrorCode.Province_Not_Existed, "省份不存在!");
        this.id = id;
    }

    @Override
    public String getDebugMessage() {
        return String.format("province[%s] is not exists", this.id);
    }
}
