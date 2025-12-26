package org.yl.post.usecase;

import org.yl.post.comment.api.PostCommentCountApi;
import org.yl.post.comment.spi.PostCommentCountSpi;
import org.yl.post.data.CommentCountData;

import java.util.UUID;

public record GetPostCommentCountUseCase(PostCommentCountSpi commentCountSpi) implements PostCommentCountApi {

    @Override
    public CommentCountData getCommentCount(UUID postId, String userEmail) {
        long count = commentCountSpi.countByPostId(postId);
        return new CommentCountData(postId, count);
    }
}
