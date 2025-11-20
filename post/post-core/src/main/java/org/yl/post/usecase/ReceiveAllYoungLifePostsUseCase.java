package org.yl.post.usecase;

import org.springframework.data.domain.Page;
import org.yl.post.api.ReceiveAllYoungLifePostsApi;
import org.yl.post.model.YoungLifePostModel;
import org.yl.post.spi.ReceiveYoungLifePostSpi;

import java.util.List;
import java.util.Optional;

public record ReceiveAllYoungLifePostsUseCase(ReceiveYoungLifePostSpi youngLifePostSpi) implements ReceiveAllYoungLifePostsApi {
    @Override
    public Optional<List<YoungLifePostModel>> getAllYoungLifePosts() {
        return youngLifePostSpi.getAllYoungLifePosts();
    }

    @Override
    public Optional<Page<YoungLifePostModel>> getFeedYoungLifePosts(int page, int size) {
        return youngLifePostSpi.getFeedYoungLifePosts(page,size);
    }
}
