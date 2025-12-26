package org.yl.post.comment.spi.adapter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yl.post.CookiesHolder;
import org.yl.post.JwtValidator;
import org.yl.post.comment.api.GetPostCommentsApi;

import java.util.UUID;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class GetPostCommentsApiAdapter {
    private final GetPostCommentsApi api;
    private final JwtValidator jwtValidator;

    @GetMapping("/comments")
    public ResponseEntity<?> getComments(HttpServletRequest request,
                                         @RequestParam UUID postId) {
        try {
            String token = CookiesHolder.getJwtTokenFromCookies(request);
            if (token == null) return ResponseEntity.status(401).body("No JWT token found in cookies");
            if (!jwtValidator.validateToken(token)) return ResponseEntity.status(401).body("Invalid JWT token");

            String email = jwtValidator.extractEmail(token);

            return ResponseEntity.ok(api.getComments(postId, email));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error loading comments: " + e.getMessage());
        }
    }
}
