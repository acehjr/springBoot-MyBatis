package com.example.unknowtruth.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;


@Component("jwtHelper")
public class JWTHelper {

    private long jwtExpDays = 30;

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public SecretKey generalKey() {
        byte[] encodedKey = Base64.decodeBase64(JWTConstant.JWT_SECRET);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 创建jwt
     *
     * @param subject 这里用来存用户Id
     * @return
     * @throws Exception
     */
    public String createJWT(String subject) throws Exception {
        // jwt有效期
        long ttlMillis = jwtExpDays * 24 * 60 * 60 * 1000;
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setIssuer(JWTConstant.JWT_ISS)
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 解密jwt
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public Claims parseJWT(String jwt) throws Exception {
        SecretKey key = generalKey();
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    public Long getUserId(String jwt)throws Exception{
        Claims claims = parseJWT(jwt);
        String sub = claims.getSubject();
        if(StringUtils.isBlank(sub)){
            throw new Exception("jwt error");
        }
        return Long.valueOf(sub);
    }


}
