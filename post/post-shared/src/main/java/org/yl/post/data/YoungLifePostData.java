package org.yl.post.data;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class YoungLifePostData {
    private UUID id;
    private YoungLifeUserData user;
    private String description;
    private String filePath;
}
