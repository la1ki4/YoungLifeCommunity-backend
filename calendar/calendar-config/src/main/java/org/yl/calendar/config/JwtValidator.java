package org.yl.calendar.config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class JwtValidator {
    private final SecretKey key;

    public JwtValidator(@Value("${jwt.secret}") String jwtSecret){
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    public String extractEmail(String token) {
        return Jwts.parser()
                .verifyWith(key).build()
                .parseSignedClaims(cleanToken(token))
                .getPayload()
                .getSubject();
    }


    public JwtUserDetails validateUser(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            return new JwtUserDetails(
                    claims.getSubject()
            );
        } catch (Exception e) {
            return null;
        }
    }

    private String cleanToken(String token) {
        return token.replace("Bearer ", "");
    }
}
