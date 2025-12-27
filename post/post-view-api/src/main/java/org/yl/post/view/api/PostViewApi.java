package org.yl.post.view.api;

import org.yl.post.data.PostViewResultData;

import java.util.UUID;

public interface PostViewApi {
    PostViewResultData addView(UUID postId, String userEmail);
}
