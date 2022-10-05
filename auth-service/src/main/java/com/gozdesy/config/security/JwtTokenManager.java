package com.gozdesy.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {

    /**
     * create+validate JWT
     */
    public Optional<String> createToken(Long id) {
        String token = null;
        String secretKey = "hello";

        try {
            token = JWT.create()
                    .withAudience()
                    .withClaim("id", id)
                    .withIssuer("gozde")
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 5))
                    .withIssuedAt(new Date())
                    .sign(Algorithm.HMAC256(secretKey));
            return Optional.of(token);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
