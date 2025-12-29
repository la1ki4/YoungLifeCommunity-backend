package org.yl.post.like.spi;

import java.util.UUID;

public interface PostLikeExistsSpi {
    boolean exists(UUID postId, UUID userId);
}
