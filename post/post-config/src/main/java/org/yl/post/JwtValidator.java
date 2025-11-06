package org.yl.post;
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

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(key).build()
                    .parseSignedClaims(cleanToken(token));
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    private String cleanToken(String token) {
        return token.replace("Bearer ", "");
    }
}
