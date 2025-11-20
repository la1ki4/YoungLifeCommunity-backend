package org.yl.post.api;

import org.springframework.data.domain.Page;
import org.yl.post.model.YoungLifePostModel;

import java.util.List;
import java.util.Optional;

public interface ReceiveAllYoungLifePostsApi {
    Optional<List<YoungLifePostModel>> getAllYoungLifePosts();
    Optional<Page<YoungLifePostModel>> getFeedYoungLifePosts(int page, int size);
}
