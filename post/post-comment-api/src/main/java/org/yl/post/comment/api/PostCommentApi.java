package org.yl.post.comment.api;

import org.yl.post.data.AddCommentRequestData;
import org.yl.post.data.CommentData;

@FunctionalInterface
public interface PostCommentApi {
    CommentData addComment(AddCommentRequestData request, String userEmail);
}
