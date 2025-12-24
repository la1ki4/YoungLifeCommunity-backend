package org.yl.post.like.api;

import org.yl.post.data.PostLikeCountData;

import java.util.UUID;

@FunctionalInterface
public interface PostLikeCountApi {
    PostLikeCountData getLikeInfo(UUID postId);
}
