package com.p2p.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    /**
     * 过期时间15分钟
     */
    private static final long EXPIRE_TIME = 30 * 60 * 1000;
    /**
     * token私钥
     */
    private static final String TOKEN_SECRET="DD5654D654DSD5S1D65S4D65S1D";


    /**
     * 生成签名15分钟后过期
     *
     * @param userName  用户名
     * @return 加密的token
     */
    public static String  sign(String userName){
        try {
            //过期时间
            Date date =new Date(System.currentTimeMillis()+EXPIRE_TIME);
            //私钥及加密算法
            Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header=new HashMap<>(2);
            header.put("typ","JWT");
            header.put("alg","hs256");
            //附带userName userId信息，生成签名
            return  JWT.create()
                    .withHeader(header)
                    .withClaim("user",userName)
                    .withExpiresAt(date)
                    .sign(algorithm);

        }catch (Exception ex){
            return null;
        }
    }

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @return  是否正确
     */
    public static boolean  verify(String token){
        try{
            Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier=JWT.require(algorithm)
                    .build();
            DecodedJWT JWT=verifier.verify(token);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
    public static  Date errorTime (String token){
        DecodedJWT decode = JWT.decode(token);
        Date expiresAt = decode.getExpiresAt();
        System.out.println(expiresAt);
        return expiresAt;
    }
    /**
     * 获取token中的信息无需secret解密也能获取
     *
     * @param token 密钥
     * @return  token中包含的用户名
     */
    public static String  getUser(String token){
        try {
            DecodedJWT jwt=JWT.decode(token);
            return  jwt.getClaim("user").asString();
        }catch (JWTDecodeException ex){
            return null;
        }
    }

}
