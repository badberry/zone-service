package cn.cloudtop.basic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jackie on 16-5-13
 */
@ApiModel
public class DetailMoreInfo {

    @ApiModelProperty("所在服务")
    private String service;
    @ApiModelProperty("相对路径")
    private String relativeUrl;

    public DetailMoreInfo(String service, String relativeUrl) {
        this.service = service;
        this.relativeUrl = relativeUrl;
    }

    public String getService() {
        return service;
    }

    public String getRelativeUrl() {
        return relativeUrl;
    }
}
