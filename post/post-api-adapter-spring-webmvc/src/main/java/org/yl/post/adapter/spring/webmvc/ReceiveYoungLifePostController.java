package org.yl.post.adapter.spring.webmvc;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/feed")
    public Optional<Page<YoungLifePostModel>> getFeed(@RequestParam(defaultValue = "0") int pageNum,
                                                      @RequestParam(defaultValue = "10") int pageSize) {
        return receiveAllYoungLifePostsApi.getFeedYoungLifePosts(pageNum, pageSize);
    }
}
