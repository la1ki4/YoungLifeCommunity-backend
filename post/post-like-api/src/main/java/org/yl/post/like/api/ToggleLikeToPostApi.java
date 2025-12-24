package org.yl.post.like.api;

import org.yl.post.data.YoungLifePostLikeData;

import java.util.UUID;

@FunctionalInterface
public interface ToggleLikeToPostApi {
    YoungLifePostLikeData toggleLike(UUID postId, String userEmail);
}
