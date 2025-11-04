package org.yl.post.adapter.spring.webmvc;

import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.yl.post.api.AddYoungLifePostApi;
import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class NewPostYoungLifeController {
    private final AddYoungLifePostApi addYoungLifePostApi;

    @PostMapping("/add")
    public ResponseEntity<?> addNewYoungLifePost(@RequestParam String description, @RequestParam MultipartFile media) throws IOException {
        addYoungLifePostApi.addNewPostApi(description, media);
        return ResponseEntity.ok("OK");
    }
}
