package org.yl.post.view.spi;

import java.util.UUID;

@FunctionalInterface
public interface PostViewSpi {
    boolean addViewIfNotExists(UUID userId, UUID postId);
}
