package org.yl.post.like.api.adapter;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yl.post.data.PostLikeCountData;
import org.yl.post.like.api.PostLikeCountApi;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostCountOfLikesApiAdapter {
    private final PostLikeCountApi postLikeCountApi;

    @GetMapping("/like-count")
    public ResponseEntity<PostLikeCountData> getLikeCount(@RequestParam UUID postId) {
        return ResponseEntity.ok(postLikeCountApi.getLikeInfo(postId));
    }
}
