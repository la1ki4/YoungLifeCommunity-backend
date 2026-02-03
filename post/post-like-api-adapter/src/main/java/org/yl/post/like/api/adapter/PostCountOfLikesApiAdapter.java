package org.yl.post.like.api.adapter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yl.post.CookiesHolder;
import org.yl.post.JwtValidator;
import org.yl.post.like.api.PostLikeCountApi;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostCountOfLikesApiAdapter {
    private final PostLikeCountApi postLikeCountApi;
    private final JwtValidator jwtValidator;

    @GetMapping("/like-count")
    public ResponseEntity<?> getLikeInfo(HttpServletRequest request, @RequestParam UUID postId) {
        String token = CookiesHolder.getJwtTokenFromCookies(request);
        if (token == null) return ResponseEntity.status(401).body("No JWT token");
        if (jwtValidator.validateToken(token)) return ResponseEntity.status(401).body("Invalid JWT token");

        String email = jwtValidator.extractEmail(token);
        return ResponseEntity.ok(postLikeCountApi.getLikeInfo(postId, email));
    }
}
