package org.yl.post.data;

import java.time.Instant;
import java.util.UUID;

public record CommentViewData(UUID id,
                              UUID postId,
                              String comment,
                              Instant createdAt,
                              CommentAuthorData author) {
}
