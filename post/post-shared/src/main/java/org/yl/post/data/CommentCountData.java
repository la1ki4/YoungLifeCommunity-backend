package org.yl.post.data;

import java.util.UUID;

public record CommentCountData(UUID postId, long commentCount) {
}
