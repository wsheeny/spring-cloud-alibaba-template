package com.tiny.commons.api;

/**
 * REST API 错误码
 *
 * @author knox
 * @since 2020/08/19
 */
public enum ApiErrorCode implements IErrorCode {

    /**
     * 成功
     */
    SUCCESS(200L, "操作成功"),
    /**
     * 失败
     */
    FAILED(-1L, "操作失败"),
    /**
     * 未登录，Token过期
     */
    UNAUTHORIZED(401L, "暂未登录或token已经过期"),
    /**
     * 权限不足
     */
    FORBIDDEN(403L, "权限不足"),
    /**
     * 参数校验错误
     */
    VALIDATE_FAILED(404L, "参数检验失败");

    private final long code;
    private final String message;

    ApiErrorCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiErrorCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
