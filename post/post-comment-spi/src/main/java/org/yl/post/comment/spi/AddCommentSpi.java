package org.yl.post.comment.spi;

import org.yl.post.model.CommentModel;

@FunctionalInterface
public interface AddCommentSpi {
    CommentModel addComment(CommentModel comment);
}
