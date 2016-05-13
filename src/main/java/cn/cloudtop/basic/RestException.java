package cn.cloudtop.basic;

/**
 * Created by jackie on 16-4-26
 * <p>
 * all Business Exception parent Class.
 */
public abstract class RestException extends RuntimeException {

    private int code;

    public RestException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * get code.
     *
     * @return code.
     */
    public int getCode() {
        return code;
    }

    /**
     * get debug message.
     *
     * @return
     */
    public abstract String getDebugMessage();

}
