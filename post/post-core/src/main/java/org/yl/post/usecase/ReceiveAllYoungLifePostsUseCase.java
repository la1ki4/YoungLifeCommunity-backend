package org.yl.post.usecase;

import org.springframework.data.domain.Page;
import org.yl.post.api.ReceiveAllYoungLifePostsApi;
import org.yl.post.model.YoungLifePostModel;
import org.yl.post.spi.ReceiveYoungLifePostSpi;

public record ReceiveAllYoungLifePostsUseCase(ReceiveYoungLifePostSpi youngLifePostSpi) implements ReceiveAllYoungLifePostsApi {

    @Override
    public Page<YoungLifePostModel> getFeedYoungLifePosts(int page, int size) {
        return youngLifePostSpi.getFeedYoungLifePosts(page,size);
    }
}
