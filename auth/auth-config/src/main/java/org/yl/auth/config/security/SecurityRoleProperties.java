package org.yl.auth.config.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.yl.auth.role.data.UserRoleData;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "app.security")
public class SecurityRoleProperties {
    private List<UserRoleData> initialRoles = new ArrayList<>();
}
