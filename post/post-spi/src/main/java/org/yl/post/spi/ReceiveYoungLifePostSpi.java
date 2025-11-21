package org.yl.post.spi;

import org.springframework.data.domain.Page;
import org.yl.post.model.YoungLifePostModel;


@FunctionalInterface
public interface ReceiveYoungLifePostSpi {
    Page<YoungLifePostModel> getFeedYoungLifePosts(int page, int size);
}
