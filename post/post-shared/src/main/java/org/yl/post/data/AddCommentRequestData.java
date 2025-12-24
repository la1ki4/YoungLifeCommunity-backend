package org.yl.post.data;

import java.util.UUID;

public record AddCommentRequestData(UUID postId, String comment) {}
