package org.yl.post.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class CommentModel {
    private UUID id;
    private UUID postId;
    private UUID userId;
    private String comment;
    private Instant createdAt;
}
