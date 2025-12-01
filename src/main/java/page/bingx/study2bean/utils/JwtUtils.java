package page.bingx.study2bean.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 1. 签名密钥 (随便写，但要保密，就像你的银行卡密码)
    private static final String SIGN_KEY = "bingx_library_secret_key";

    // 2. 过期时间 (这里设为 12 小时，单位毫秒)
    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;

    /**
     * 生成 JWT 令牌
     * @param claims 要存入令牌的数据 (比如用户的 id, role 等)
     * @return String 类型的 Token
     */
    public static String generateJwt(Map<String, Object> claims){
        return Jwts.builder()
                .addClaims(claims) // 载荷 (Payload): 存数据
                .signWith(SignatureAlgorithm.HS256, SIGN_KEY) // 签名 (Signature): 加密算法和密钥
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME)) // 设置过期时间
                .compact();
    }

    /**
     * 解析 JWT 令牌
     * @param jwt 令牌字符串
     * @return Claims 对象 (可以从中取出之前存的数据)
     */
    public static Claims parseJwt(String jwt){
        return Jwts.parser()
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(jwt)
                .getBody();
    }
}