package org.yl.post.like.spi;

import org.yl.post.model.PostLikeModel;
import java.util.Optional;

@FunctionalInterface
public interface PostLikeSpi {
    Optional<PostLikeModel> addPostLike(PostLikeModel postLikeModel);
}
