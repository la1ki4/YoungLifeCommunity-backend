package org.yl.auth.api.spring.webmvc.check_auth;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yl.auth.util.jwt.JwtUtil;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin
public class CheckAuthByToken {
    private final JwtUtil validateToken;

    @GetMapping("/check")
    public ResponseEntity<?> checkAuth(@CookieValue(name = "jwt", required = false) String token) {
        if (token != null && validateToken.validateToken(token)) {
            return ResponseEntity.ok(Map.of("authenticated", true));
        }
        return ResponseEntity.status(401).body(Map.of("authenticated", false));
    }
}
