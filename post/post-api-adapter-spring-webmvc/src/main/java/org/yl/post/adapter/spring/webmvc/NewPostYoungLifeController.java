package org.yl.post.adapter.spring.webmvc;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.yl.post.CookiesHolder;
import org.yl.post.JwtValidator;
import org.yl.post.api.AddYoungLifePostApi;
import java.io.IOException;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class NewPostYoungLifeController {
    private final AddYoungLifePostApi addYoungLifePostApi;
    private final JwtValidator jwtValidator;

    @PostMapping("/add")
    public ResponseEntity<?> addNewYoungLifePost(HttpServletRequest request, @RequestParam String description, @RequestParam MultipartFile media) throws IOException {

        try{
            String token = CookiesHolder.getJwtTokenFromCookies(request);
            if(token == null){
                return ResponseEntity.status(401).body("No JWT token found in cookies");
            }
            if(!jwtValidator.validateToken(token)){
                return ResponseEntity.status(401).body("Invalid JWT token");
            }
            String userEmail = jwtValidator.extractEmail(token);
            addYoungLifePostApi.addNewPostApi(description, media, userEmail);
            return ResponseEntity.ok(Map.of("status", "OK"));
        } catch (Exception exception){
            return ResponseEntity.status(500).body("Error creating post: " + exception.getMessage());
        }
    }
}
