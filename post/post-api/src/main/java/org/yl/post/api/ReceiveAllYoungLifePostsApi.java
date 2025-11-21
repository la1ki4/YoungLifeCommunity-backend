package org.yl.post.api;

import org.springframework.data.domain.Page;
import org.yl.post.model.YoungLifePostModel;

@FunctionalInterface
public interface ReceiveAllYoungLifePostsApi {
    Page<YoungLifePostModel> getFeedYoungLifePosts(int page, int size);
}
