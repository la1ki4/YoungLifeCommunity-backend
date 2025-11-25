package org.yl.post.usecase;

import org.springframework.data.domain.Page;
import org.yl.post.api.ReceiveAllYoungLifePostsApi;
import org.yl.post.data.YoungLifePostData;
import org.yl.post.spi.ReceiveYoungLifePostSpi;

public record ReceiveAllYoungLifePostsUseCase(ReceiveYoungLifePostSpi youngLifePostSpi) implements ReceiveAllYoungLifePostsApi {

    @Override
    public Page<YoungLifePostData> getFeedYoungLifePosts(int page, int size) {
        return youngLifePostSpi.getFeedYoungLifePosts(page,size);
    }
}
