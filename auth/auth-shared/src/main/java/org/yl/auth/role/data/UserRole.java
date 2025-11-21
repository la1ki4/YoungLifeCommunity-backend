package org.yl.auth.role.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    YL_USER(1),
    YL_VOLUNTEER(2),
    YL_LEADER(3);

    private final int rolePriorityLevel;
}
