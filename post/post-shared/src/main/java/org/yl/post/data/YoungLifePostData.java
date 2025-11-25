package org.yl.post.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class YoungLifePostData {
    private YoungLifeUserData user;
    private String description;
    private String filePath;
}
