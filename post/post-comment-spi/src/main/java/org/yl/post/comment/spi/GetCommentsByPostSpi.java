package org.yl.post.comment.spi;

import org.yl.post.model.CommentModel;

import java.util.List;
import java.util.UUID;

@FunctionalInterface
public interface GetCommentsByPostSpi {
    List<CommentModel> getByPostId(UUID postId);
}
