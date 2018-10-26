package com.eternalray.utils.jwt;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;

/**
 * @Author: Eternalray
 *  JWT 工具类
 */
@Slf4j
public class JwtUtil {

    /**
     * SECRET JWT token SECRET
     */
    private final static String SECRET="YOUR_SECRET";

    /**
     * 获得JWT token
     * @param expires       token过期时间(单位：秒)
     * @param params        附带的其它参数
     * @return
     */
    public static String getToken(Long expires, Map<String,Object> params){
        String token = null;
        try {
            //加密方式
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            System.out.println(algorithm.toString());
            //过期时间
            Date expiresDate = new Date(System.currentTimeMillis()+expires*1000);
            token = JWT.create()
                    .withClaim("params",JSONObject.toJSONString(params))
                    .withExpiresAt(expiresDate)
                    .sign(algorithm);
        } catch (JWTCreationException e){
            log.debug("获得JWT token 失败！",e.getMessage());
        }
        return token;
    }

    /**
     * 验证JWT token
     * @param token
     * @return
     */
    public static DecodedJWT verifyToken(String token){
        DecodedJWT jwt = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            jwt=verifier.verify(token);
        } catch (JWTVerificationException e){
            log.debug("验证JWT token 失败！",e.getMessage());
        }
        return jwt;
    }
}
