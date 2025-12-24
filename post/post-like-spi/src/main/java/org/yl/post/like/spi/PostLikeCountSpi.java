package org.yl.post.like.spi;

import java.util.UUID;

@FunctionalInterface
public interface PostLikeCountSpi {
    long countLikes(UUID postId);
}