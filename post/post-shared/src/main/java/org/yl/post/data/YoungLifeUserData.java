package org.yl.post.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class YoungLifeUserData {
    private String firstName;
    private String lastName;
    private YoungLifeUserRoleData userRole;
}
