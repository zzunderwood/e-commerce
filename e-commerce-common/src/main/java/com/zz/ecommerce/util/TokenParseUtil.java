package com.zz.ecommerce.util;

import com.alibaba.fastjson.JSON;
import com.zz.ecommerce.constant.CommonConstant;
import com.zz.ecommerce.vo.LoginUserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import sun.misc.BASE64Decoder;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;

/**
 * JWT Token 解析工具类
 * @Author zz
 * @Version 1.0
 * @Date 2023/6/15 03:01
 */
public class TokenParseUtil {

    /**
     * 从JWT token 中解析 LoginUserInfo 对象
     * @param token
     * @return
     * @throws Exception
     */
    public static LoginUserInfo  parseUserInfoFromToken(String token) throws Exception {
        if (null == token) {
            return null;
        }
        Jws<Claims> claimsJws = parseToken(token, getPublicKey());

        Claims body = claimsJws.getBody();
        //如果token已经过期了，返回null
        if (body.getExpiration().before(Calendar.getInstance().getTime())) {
            return null;
        }

        //返回token 中保存的用户信息
        return JSON.parseObject(
                body.get(CommonConstant.JWT_USER_INFO_KEY).toString(),
                LoginUserInfo.class
        );
    }

    /**
     * 根据本地存储的公钥获取 PublicKey 对象
     * @return
     * @throws Exception
     */
     private static PublicKey getPublicKey()throws  Exception {
         X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
                 new BASE64Decoder().decodeBuffer(CommonConstant.PUBLIC_KEY)
         );
         return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
     }

    /**
     * 通过公钥解析token
     * @param token
     * @param publicKey
     * @return
     */
    private static Jws<Claims> parseToken(String token, PublicKey publicKey) {
        return Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
    }
}
