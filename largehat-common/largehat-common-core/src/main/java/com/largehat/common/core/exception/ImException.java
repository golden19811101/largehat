package com.largehat.common.core.exception;

/**
 * @ClassName ImException
 * @Description Im异常类
 * @Author Lion
 * @Version 1.0
 **/
public class ImException extends Exception {

    /**
     * @Author Lion
     * @Description
     * @return
     **/
    public ImException() {
    }

    /**
     * @Author Lion
     * @Description
     * @return
     **/
    public ImException(String message) {
        super(message);

    }

    /**
     * @Author Lion
     * @Description
     * @return
     **/
    public ImException(String message, Throwable cause) {
        super(message, cause);

    }

    /**
     * @Author Lion
     * @Description
     * @return
     **/
    public ImException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    /**
     * @Author Lion
     * @Descriptione
     * @return
     **/
    public ImException(Throwable cause) {
        super(cause);

    }
}
