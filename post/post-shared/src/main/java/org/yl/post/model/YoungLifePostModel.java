package org.yl.post.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class YoungLifePostModel {
    private UUID id;
    private String description;
    private String fileName;
    private String filePath;
    private String contentType;
    private LocalDateTime uploadedAt;
    private YoungLifeUserModel user;
}
