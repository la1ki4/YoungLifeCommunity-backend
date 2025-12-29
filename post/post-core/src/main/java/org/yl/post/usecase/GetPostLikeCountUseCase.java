package org.yl.post.usecase;

import org.yl.post.data.PostLikeCountData;
import org.yl.post.like.api.PostLikeCountApi;
import org.yl.post.like.spi.PostLikeCountSpi;
import org.yl.post.like.spi.PostLikeExistsSpi;
import org.yl.post.spi.YoungLifeUserByEmailSpi;

import java.util.UUID;

public record GetPostLikeCountUseCase(PostLikeCountSpi postLikeCountSpi,
                                      PostLikeExistsSpi postLikeExistsSpi,
                                      YoungLifeUserByEmailSpi userByEmailSpi) implements PostLikeCountApi {

    @Override
    public PostLikeCountData getLikeInfo(UUID postId, String userEmail) {
        UUID userId = userByEmailSpi.getYoungLifeUserByEmail(userEmail).getId();

        boolean liked = postLikeExistsSpi.exists(postId, userId);
        long likeCount = postLikeCountSpi.countLikes(postId);

        return new PostLikeCountData(likeCount, liked);
    }
}
