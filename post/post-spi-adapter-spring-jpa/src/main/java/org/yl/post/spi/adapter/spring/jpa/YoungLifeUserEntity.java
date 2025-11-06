package org.yl.post.spi.adapter.spring.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.yl.post.model.YoungLifeUserModel;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "yl_users")
@Getter
@Setter
public class YoungLifeUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<YoungLifePostEntity> posts;
}