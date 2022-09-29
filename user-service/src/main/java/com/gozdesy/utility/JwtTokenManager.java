package com.gozdesy.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtTokenManager {

    /**
     * create+validate JWT
     */
    public boolean validateToken(String token) {
        try {
           Algorithm algorithm = Algorithm.HMAC256("hello");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("")
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
                    if(decodedJWT == null)
                        return false;

        } catch(Exception e) {
            return false;
        }
        return true;
    }

    public Optional<Long> getUserId(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("hello");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("gozde")
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if(decodedJWT == null)
                return Optional.empty();
            return Optional.of(decodedJWT.getClaim("id").asLong());
        } catch(Exception e) {
            return Optional.empty();
        }
    }
}
