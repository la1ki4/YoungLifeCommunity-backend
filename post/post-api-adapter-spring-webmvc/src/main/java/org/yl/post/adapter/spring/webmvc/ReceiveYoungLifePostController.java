package org.yl.post.adapter.spring.webmvc;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yl.post.api.ReceiveAllYoungLifePostsApi;
import org.yl.post.model.YoungLifePostModel;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class ReceiveYoungLifePostController {
    private final ReceiveAllYoungLifePostsApi receiveAllYoungLifePostsApi;

    @GetMapping("/all")
    public Optional<List<YoungLifePostModel>> getPosts() {
        return receiveAllYoungLifePostsApi.getAllYoungLifePosts();
    }
}
