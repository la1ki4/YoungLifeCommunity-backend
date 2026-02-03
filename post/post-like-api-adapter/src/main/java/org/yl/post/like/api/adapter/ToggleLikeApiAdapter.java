package org.yl.post.like.api.adapter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yl.post.CookiesHolder;
import org.yl.post.JwtValidator;
import org.yl.post.data.YoungLifePostLikeData;
import org.yl.post.like.api.ToggleLikeToPostApi;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class ToggleLikeApiAdapter {
    private final ToggleLikeToPostApi postLikeApi;
    private final JwtValidator jwtValidator;

    @PostMapping("/toggle-like")
    public ResponseEntity<?> toggleLike(HttpServletRequest request, @RequestParam UUID postId){
        try{
            String token = CookiesHolder.getJwtTokenFromCookies(request);
            if(token == null){
                return ResponseEntity.status(401).body("No JWT token found in cookies");
            }
            if(jwtValidator.validateToken(token)){
                return ResponseEntity.status(401).body("Invalid JWT token");
            }
            String userEmail = jwtValidator.extractEmail(token);
            YoungLifePostLikeData postLikeData = postLikeApi.toggleLike(postId, userEmail);
            return ResponseEntity.ok(postLikeData);
        } catch (Exception exception){
            return ResponseEntity.status(500).body("Error liking post: " + exception.getMessage());
        }
    }
}
