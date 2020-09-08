package com.lf.mimall.oauth2.exception;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/9/7
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public class JwtInvalidException extends RuntimeException {
    public JwtInvalidException(String message) {
        super(message);
    }
}
