package com.tiny.commons.exception;

import com.tiny.commons.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 *
 * @author knox
 * @since 2020/2/27
 */
public class Asserts {
    /**
     * 抛失败异常
     *
     * @param message 说明
     */
    public static void fail(String message) {
        throw new ApiException(message);
    }

    /**
     * 抛失败异常
     *
     * @param errorCode 状态码
     */
    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
