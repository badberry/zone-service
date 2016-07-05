package cn.cloudtop.basic;

/**
 * Created by jackie on 16-4-26
 */
public class FieldValidError {
    private String objectName;
    private String field;
    private Object value;
    private String message;

    public FieldValidError(String objectName, String field, Object value, String message) {
        this.objectName = objectName;
        this.field = field;
        this.value = value;
        this.message = message;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getField() {
        return field;
    }

    public Object getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
