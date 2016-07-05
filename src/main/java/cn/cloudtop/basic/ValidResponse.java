package cn.cloudtop.basic;

import java.util.List;

/**
 * Created by jackie on 16-4-26
 */
public class ValidResponse extends RestResponse {


    private String paramName;
    private List<FieldValidError> fieldErrors;

    public ValidResponse(String paramName, List<FieldValidError> fieldErrors) {
        super(BasicErrorCode.Field_Valid_Error, "param valid error,detail see fieldErrors.");
        this.paramName = paramName;
        this.fieldErrors = fieldErrors;
    }

    public String getParamName() {
        return paramName;
    }

    public List<FieldValidError> getFieldErrors() {
        return fieldErrors;
    }
}
