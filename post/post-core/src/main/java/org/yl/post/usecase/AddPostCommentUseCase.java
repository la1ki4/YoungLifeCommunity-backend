package org.yl.post.usecase;

import org.yl.post.comment.api.PostCommentApi;
import org.yl.post.comment.spi.AddCommentSpi;
import org.yl.post.data.AddCommentRequestData;
import org.yl.post.data.CommentData;
import org.yl.post.model.CommentModel;
import org.yl.post.spi.YoungLifeUserByEmailSpi;

import java.time.Instant;

public record AddPostCommentUseCase(
        AddCommentSpi addCommentSpi,
        YoungLifeUserByEmailSpi userByEmailSpi
) implements PostCommentApi {

    @Override
    public CommentData addComment(AddCommentRequestData request, String userEmail) {
        var userId = userByEmailSpi.getYoungLifeUserByEmail(userEmail).getId();

        var saved = addCommentSpi.addComment(CommentModel.builder()
                .postId(request.postId())
                .userId(userId)
                .comment(request.comment())
                .createdAt(Instant.now())
                .build());

        return new CommentData(
                saved.getId(),
                saved.getPostId(),
                saved.getUserId(),
                saved.getComment(),
                saved.getCreatedAt()
        );
    }
}