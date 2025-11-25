package org.yl.post.spi;

import org.springframework.data.domain.Page;
import org.yl.post.data.YoungLifePostData;


@FunctionalInterface
public interface ReceiveYoungLifePostSpi {
    Page<YoungLifePostData> getFeedYoungLifePosts(int page, int size);
}
