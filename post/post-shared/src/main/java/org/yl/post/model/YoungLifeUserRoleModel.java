package org.yl.post.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class YoungLifeUserRoleModel {
    private UUID id;
    private String roleName;
    private int rolePriority;
}
