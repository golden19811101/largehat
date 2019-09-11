package com.largehat.common.im.exception;

/**
 * @ClassName ImException
 * @Description Im异常类
 * @Date 2019/6/13 3:28
 * @Version 1.0
 **/
public class ImException extends RuntimeException {

    /**
     * @return
     * @Author
     * @Description
     **/
    public ImException() {

    }

    /**
     * @return
     * @Description
     **/
    public ImException(String message) {
        super(message);

    }

    /**
     * @return
     * @Description
     **/
    public ImException(String message, Throwable cause) {
        super(message, cause);

    }

    /**
     * @return
     * @Description
     **/
    public ImException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    /**
     * @return
     * @Description
     **/
    public ImException(Throwable cause) {
        super(cause);

    }
}
