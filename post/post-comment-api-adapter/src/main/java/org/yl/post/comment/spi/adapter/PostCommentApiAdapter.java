package org.yl.post.comment.spi.adapter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yl.post.CookiesHolder;
import org.yl.post.JwtValidator;
import org.yl.post.comment.api.PostCommentApi;
import org.yl.post.data.AddCommentRequestData;
import org.yl.post.data.CommentData;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostCommentApiAdapter {
    private final PostCommentApi postCommentApi;
    private final JwtValidator jwtValidator;

    @PostMapping("/add-comment")
    public ResponseEntity<?> addComment(HttpServletRequest request,
                                        @RequestBody AddCommentRequestData body) {
        try {
            String token = CookiesHolder.getJwtTokenFromCookies(request);
            if (token == null) return ResponseEntity.status(401).body("No JWT token found in cookies");
            if (jwtValidator.validateToken(token)) return ResponseEntity.status(401).body("Invalid JWT token");

            String email = jwtValidator.extractEmail(token);
            CommentData saved = postCommentApi.addComment(body, email);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding comment: " + e.getMessage());
        }
    }
}
