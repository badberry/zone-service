package cn.cloudtop.basic;

/**
 * Created by jackie on 16-4-26
 */
public interface Response {
    /**
     * request is success or not.
     *
     * @return true:success,false:failed.
     */
    boolean isSuccess();

    /**
     * if request failed,this field provide error code message.
     * if request success,this field is null or empty.
     *
     * @return error code.
     */
    int getErrorCode();

    /**
     * if request failed,this field provide error message.
     * if request success,this field is null or empty.
     *
     * @return error message.
     */
    String getErrorMessage();

    /**
     * server response time.
     *
     * @return linux timestamp(millis) of response.
     */
    long getTimestamp();
}
