package org.yl.auth.spring.jpa.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="yl_roles")
@Getter
@Setter
public class YoungLifeUserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_priority_level")
    private Integer rolePriorityLevel;
}
