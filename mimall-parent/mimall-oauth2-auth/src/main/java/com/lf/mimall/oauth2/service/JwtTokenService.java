package com.lf.mimall.oauth2.service;

import com.lf.mimall.oauth2.entity.PayloadDto;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;

import java.text.ParseException;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author LF
 * @Date 2020/9/7
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （必须）
 */
public interface JwtTokenService {


    /**
     * 使用HMAC算法生成token
     */
    String generateTokenByHMAC(String payloadStr, String secret) throws JOSEException;

    /**
     * 使用HMAC算法校验token
     */
    PayloadDto verifyTokenByHMAC(String token, String secret) throws ParseException, JOSEException, ParseException;

    /**
     * 使用RSA算法生成token
     */
    String generateTokenByRSA(String payloadStr, RSAKey rsaKey) throws JOSEException;

    /**
     * 使用RSA算法校验token
     */
    PayloadDto verifyTokenByRSA(String token, RSAKey rsaKey) throws ParseException, JOSEException;

    /**
     * 获取默认payload
     */
    PayloadDto getDefaultPayloadDto();

    /**
     * 获取默认的RSAKey
     */
    RSAKey getDefaultRSAKey();
}
