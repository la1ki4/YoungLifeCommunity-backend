package org.yl.post.usecase;

import org.yl.post.data.PostLikeCountData;
import org.yl.post.like.api.PostLikeCountApi;
import org.yl.post.like.spi.PostLikeCountSpi;

import java.util.UUID;

public record GetPostLikeCountUseCase(PostLikeCountSpi postLikeCountSpi) implements PostLikeCountApi {

    @Override
    public PostLikeCountData getLikeInfo(UUID postId) {
        long likeCount = postLikeCountSpi.countLikes(postId);
        return new PostLikeCountData(likeCount);
    }
}
