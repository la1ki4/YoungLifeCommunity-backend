package org.yl.post.api;

import org.yl.post.model.YoungLifePostModel;
import java.util.List;
import java.util.Optional;

@FunctionalInterface
public interface ReceiveAllYoungLifePostsApi {
    Optional<List<YoungLifePostModel>> getAllYoungLifePosts();
}
