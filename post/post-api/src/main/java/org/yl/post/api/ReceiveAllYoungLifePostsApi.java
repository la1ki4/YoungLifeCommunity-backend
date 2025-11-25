package org.yl.post.api;

import org.springframework.data.domain.Page;
import org.yl.post.data.YoungLifePostData;

@FunctionalInterface
public interface ReceiveAllYoungLifePostsApi {
    Page<YoungLifePostData> getFeedYoungLifePosts(int page, int size);
}
