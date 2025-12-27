package org.yl.post.usecase;

import org.yl.post.data.PostViewResultData;
import org.yl.post.spi.YoungLifeUserByEmailSpi;
import org.yl.post.view.api.PostViewApi;
import org.yl.post.view.spi.PostViewCountSpi;
import org.yl.post.view.spi.PostViewSpi;

import java.util.UUID;

public record AddPostViewUseCase(PostViewSpi postViewSpi,
                                 PostViewCountSpi postViewCountSpi,
                                 YoungLifeUserByEmailSpi userByEmailSpi) implements PostViewApi {
    @Override
    public PostViewResultData addView(UUID postId, String userEmail) {
        UUID userId = userByEmailSpi.getYoungLifeUserByEmail(userEmail).getId();

        boolean viewedNow = postViewSpi.addViewIfNotExists(userId, postId);
        long viewCount = postViewCountSpi.countViews(postId);

        return new PostViewResultData(viewedNow, viewCount);
    }
}
