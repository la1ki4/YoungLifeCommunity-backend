package org.yl.post.model;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class YoungLifeUserModel {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Timestamp createdAt;
    private List<YoungLifePostModel> posts;
}
