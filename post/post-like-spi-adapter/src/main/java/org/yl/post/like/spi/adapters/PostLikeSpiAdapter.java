package org.yl.post.like.spi.adapters;

import org.yl.post.like.spi.PostLikeSpi;
import org.yl.post.model.PostLikeModel;

import java.util.Optional;

public class PostLikeSpiAdapter implements PostLikeSpi {
    @Override
    public Optional<PostLikeModel> addPostLike(PostLikeModel postLikeModel) {

        return Optional.empty();
    }
}
