package org.yl.post.usecase;

import org.yl.post.comment.api.GetPostCommentsApi;
import org.yl.post.comment.spi.GetCommentsByPostSpi;
import org.yl.post.data.CommentAuthorData;
import org.yl.post.data.CommentViewData;
import org.yl.post.spi.YoungLifeUserByEmailSpi;

import java.util.List;
import java.util.UUID;

public record GetPostCommentsUseCase(GetCommentsByPostSpi getCommentsByPostSpi,
                                     YoungLifeUserByEmailSpi userByEmailSpi) implements GetPostCommentsApi {
    @Override
    public List<CommentViewData> getComments(UUID postId, String userEmail) {
        var comments = getCommentsByPostSpi.getByPostId(postId);

        return comments.stream().map(c -> {
            var user = userByEmailSpi.getYoungLifeUserByEmail(userEmail);

            return new CommentViewData(
                    c.getId(),
                    c.getPostId(),
                    c.getComment(),
                    c.getCreatedAt(),
                    new CommentAuthorData(
                            user.getId(),
                            user.getFirstName(),
                            user.getLastName(),
                            user.getUserRole().getRoleName()
                    )
            );
        }).toList();
    }
}
