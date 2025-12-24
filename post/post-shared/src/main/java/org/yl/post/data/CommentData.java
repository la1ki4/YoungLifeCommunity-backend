package org.yl.post.data;

import java.time.Instant;
import java.util.UUID;

public record CommentData(UUID id,
                          UUID postId,
                          UUID userId,
                          String comment,
                          Instant createdAt) {
}
