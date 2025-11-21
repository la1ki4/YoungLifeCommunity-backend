package org.yl.auth.spring.jpa.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.yl.auth.model.YoungLifeUserModel;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="yl_users")
@Getter
@Setter
public class YoungLifeUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email", unique=true)
    private String email;
    @Column(name="password")
    private String password;
    @OneToOne
    @JoinColumn(name = "user_role_id")
    private YoungLifeUserRoleEntity userRole;
    @Column(name="created_at")
    private Timestamp createdAt;
}
