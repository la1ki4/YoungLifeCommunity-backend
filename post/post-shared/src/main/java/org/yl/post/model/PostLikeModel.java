package org.yl.post.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PostLikeModel {
    private UUID id;
    private UUID postId;
    private UUID userId;
}
