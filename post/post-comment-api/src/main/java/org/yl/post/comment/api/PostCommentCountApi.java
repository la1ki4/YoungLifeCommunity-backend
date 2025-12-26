package org.yl.post.comment.api;

import org.yl.post.data.CommentCountData;

import java.util.UUID;

@FunctionalInterface
public interface PostCommentCountApi {
    CommentCountData getCommentCount(UUID postId, String userEmail);
}
