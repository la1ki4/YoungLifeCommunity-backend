package org.yl.post.view.api.adapter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yl.post.CookiesHolder;
import org.yl.post.JwtValidator;
import org.yl.post.view.api.PostViewApi;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostViewApiAdapter {

    private final PostViewApi postViewApi;
    private final JwtValidator jwtValidator;

    @PostMapping("/view")
    public ResponseEntity<?> addView(HttpServletRequest request,
                                     @RequestParam UUID postId) {
        try {
            String token = CookiesHolder.getJwtTokenFromCookies(request);
            if (token == null) return ResponseEntity.status(401).body("No JWT token found in cookies");
            if (!jwtValidator.validateToken(token)) return ResponseEntity.status(401).body("Invalid JWT token");

            String email = jwtValidator.extractEmail(token);

            return ResponseEntity.ok(postViewApi.addView(postId, email));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding view: " + e.getMessage());
        }
    }
}
