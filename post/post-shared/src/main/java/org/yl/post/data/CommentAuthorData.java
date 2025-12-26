package org.yl.post.data;

import java.util.UUID;

public record CommentAuthorData(UUID id,
                                String firstName,
                                String lastName,
                                String roleName) {}
