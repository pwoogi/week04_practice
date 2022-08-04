package com.sparta.week04_practice.jwt;


import io.jsonwebtoken.security.Keys;
import org.springframework.data.util.Pair;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;

/**
 * JWT Key를 제공하고 조회합니다.
 */
public class JwtKey {
    /**
     * Kid-Key List 외부로 절대 유출되어서는 안됩니다.
     */

    //아래 Map이용해서 unmodifiableMap 메서드 그냥 구글링해서 가져왔는데 맞는지도 모르겠음..
    private static final Map<String, String> SECRET_KEY_SET =
    Collections.unmodifiableMap(new HashMap<String, String>() {
        {
            put("key01", "SpringSecurityJWTPracticeProjectIsSoGoodAndThisProjectIsSoFunSpringSecurityJWTPracticeProjectIsSoGoodAndThisProjectIsSoFun");
            put("key02", "GoodSpringSecurityNiceSpringSecurityGoodSpringSecurityNiceSpringSecurityGoodSpringSecurityNiceSpringSecurityGoodSpringSecurityNiceSpringSecurity");
            put("key03", "HelloSpringSecurityHelloSpringSecurityHelloSpringSecurityHelloSpringSecurityHelloSpringSecurityHelloSpringSecurityHelloSpringSecurityHelloSpringSecurity");
        }
    });

    private static final String[] KID_SET = SECRET_KEY_SET.keySet().toArray(new String[0]);
    private static Random randomIndex = new Random();

    /**
     * SECRET_KEY_SET 에서 랜덤한 KEY 가져오기
     *
     * @return kid와 key Pair
     */
    public static Pair<String, Key> getRandomKey() {
        String kid = KID_SET[randomIndex.nextInt(KID_SET.length)];
        String secretKey = SECRET_KEY_SET.get(kid);
        return Pair.of(kid, Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * kid로 Key찾기
     *
     * @param kid kid
     * @return Key
     */
    public static Key getKey(String kid) {
        String key = SECRET_KEY_SET.getOrDefault(kid, null);
        if (key == null)
            return null;
        return Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
    }
}