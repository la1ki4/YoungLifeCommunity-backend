package org.yl.post.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Builder
public class YoungLifePostModel {
    private UUID id;
    private String description;
    private String fileName;
    private String filePath;
    private String contentType;
    private Timestamp uploadedAt;
    private YoungLifeUserModel user;
}
