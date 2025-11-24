package org.yl.post.spi.adapter.spring.jpa.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="yl_roles")
@Getter
@Setter
public class YoungLifeUserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "role_name", nullable = false)
    private String roleName;
    @Column(name = "role_priority_level", nullable = false)
    private Integer rolePriorityLevel;
    @OneToMany(mappedBy = "userRole")
    private List<YoungLifeUserEntity> users = new ArrayList<>();
}
