package com.lf.mimallnacos.entity;

/**
 * 自定义返回码
 *
 * @author admin
 */

public enum ErrorCode {
    /**
     * 成功
     */
    OK(0, "success"),
    FAIL(1000, "fail"),
    ALERT(1001, "alert"),

    /**
     * oauth2返回码
     */
    INVALID_TOKEN(1002, "invalid_token"),
    INVALID_SCOPE(1003, "invalid_scope"),
    INVALID_REQUEST(1004, "invalid_request"),
    INVALID_CLIENT(1005, "invalid_client"),
    INVALID_GRANT(1006, "invalid_grant"),
    REDIRECT_URI_MISMATCH(1007, "redirect_uri_mismatch"),
    UNAUTHORIZED_CLIENT(1008, "unauthorized_client"),
    EXPIRED_TOKEN(1009, "expired_token"),
    UNSUPPORTED_GRANT_TYPE(1010, "unsupported_grant_type"),
    UNSUPPORTED_RESPONSE_TYPE(1011, "unsupported_response_type"),
    UNAUTHORIZED(1012, "unauthorized"),
    SIGNATURE_DENIED(1013, "signature_denied"),

    /**
     * 账号错误
     */
    BAD_CREDENTIALS(1014, "bad_credentials"),
    ACCOUNT_DISABLED(1015, "account_disabled"),
    ACCOUNT_EXPIRED(1016, "account_expired"),
    CREDENTIALS_EXPIRED(1017, "credentials_expired"),
    ACCOUNT_LOCKED(1018, "account_locked"),
    USERNAME_NOT_FOUND(1019, "username_not_found"),

    ACCESS_DENIED(1020, "access_denied"),
    ACCESS_DENIED_BLACK_LIMITED(1021, "access_denied_black_limited"),
    ACCESS_DENIED_WHITE_LIMITED(1022, "access_denied_white_limited"),
    ACCESS_DENIED_AUTHORITY_EXPIRED(1023, "access_denied_authority_expired"),
    ACCESS_DENIED_UPDATING(1024, "access_denied_updating"),
    ACCESS_DENIED_DISABLED(1025, "access_denied_disabled"),
    ACCESS_DENIED_NOT_OPEN(1026, "access_denied_not_open"),

    /**
     * 请求错误
     */
    BAD_REQUEST(400, "bad_request"),
    NOT_FOUND(404, "not_found"),
    METHOD_NOT_ALLOWED(405, "method_not_allowed"),
    MEDIA_TYPE_NOT_ACCEPTABLE(406, "media_type_not_acceptable"),
    TOO_MANY_REQUESTS(429, "too_many_requests"),
    /**
     * 系统错误
     */
    ERROR(500, "error"),
    GATEWAY_TIMEOUT(504, "gateway_timeout"),
    SERVICE_UNAVAILABLE(503, "service_unavailable"),

    /**
     * sentinel流控
     */
    DEGRADE_EXCEPTION(101,"degrade exception"),
    PARAMFLOW_EXCEPTION(102,"paramflow exception"),
    SYSTEMBLOCK_EXCEPTION(103,"systemblock exception"),
    SENTINEL_AUTH_EXCEPTION(104,"sentinel auth exception"),
    FLOW_EXCEPTION(100,"flow exception"),

    /**
     * 基础业务参数错误
     */
    INVALIDE_PARAM(200,"invalide_parameter");

    private int code;
    private String message;

    ErrorCode() {
    }

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorCode getResultEnum(int code) {
        for (ErrorCode type : ErrorCode.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return ERROR;
    }

    public static ErrorCode getResultEnum(String message) {
        for (ErrorCode type : ErrorCode.values()) {
            if (type.getMessage().equals(message)) {
                return type;
            }
        }
        return ERROR;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
