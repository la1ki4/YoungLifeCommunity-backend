package org.yl.post.usecase;

import org.yl.post.data.YoungLifePostLikeData;
import org.yl.post.like.api.ToggleLikeToPostApi;
import org.yl.post.like.spi.PostLikeCountSpi;
import org.yl.post.like.spi.PostLikeSpi;
import org.yl.post.model.PostLikeModel;
import org.yl.post.spi.YoungLifeUserByEmailSpi;

import java.util.Optional;
import java.util.UUID;

public record ToggleYoungLifePostUseCase(PostLikeSpi postLikeSpi, PostLikeCountSpi postLikeCountSpi,
                                         YoungLifeUserByEmailSpi userByEmailSpi) implements ToggleLikeToPostApi {
    @Override
    public YoungLifePostLikeData toggleLike(UUID postId, String userEmail) {

        UUID userId = userByEmailSpi.getYoungLifeUserByEmail(userEmail).getId();
        PostLikeModel likeModel = PostLikeModel.builder()
                .postId(postId)
                .userId(userId)
                .build();

        Optional<PostLikeModel> likedNow = postLikeSpi.togglePostLike(likeModel);
        boolean liked = likedNow.isPresent();
        long likeCount = postLikeCountSpi().countLikes(postId);

        return new YoungLifePostLikeData(liked, likeCount);
    }
}
