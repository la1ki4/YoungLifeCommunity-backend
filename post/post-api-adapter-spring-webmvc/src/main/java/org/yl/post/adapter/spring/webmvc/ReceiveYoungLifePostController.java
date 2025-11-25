package org.yl.post.adapter.spring.webmvc;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yl.post.api.ReceiveAllYoungLifePostsApi;
import org.yl.post.data.YoungLifePostData;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class ReceiveYoungLifePostController {
    private final ReceiveAllYoungLifePostsApi receiveAllYoungLifePostsApi;

    @GetMapping("/feed")
    public Page<YoungLifePostData> getFeed(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size) {
        return receiveAllYoungLifePostsApi.getFeedYoungLifePosts(page, size);
    }
}
