package org.yl.post.comment.api;

import org.yl.post.data.CommentViewData;

import java.util.List;
import java.util.UUID;

@FunctionalInterface
public interface GetPostCommentsApi {
    List<CommentViewData> getComments(UUID postId, String userEmail);
}
