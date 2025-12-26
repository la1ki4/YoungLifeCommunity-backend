package org.yl.post.comment.spi;

import java.util.UUID;

@FunctionalInterface
public interface PostCommentCountSpi {
    long countByPostId(UUID postId);
}
