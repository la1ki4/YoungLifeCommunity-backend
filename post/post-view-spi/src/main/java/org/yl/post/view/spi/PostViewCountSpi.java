package org.yl.post.view.spi;

import java.util.UUID;

public interface PostViewCountSpi {
    long countViews(UUID postId);
}
