package org.yl.auth.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
public class YoungLifeUserModel {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Timestamp createdAt;
}
