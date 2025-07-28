package org.yl.auth.adapter.out.persistance;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.yl.auth.core.model.YoungLifeUserModel;

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
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="created_at")
    private Timestamp createdAt;

    public static YoungLifeUserEntity fromModel(YoungLifeUserModel model) {
        YoungLifeUserEntity entity = new YoungLifeUserEntity();
        entity.email = model.getEmail();
        entity.password = model.getPassword();
        entity.firstName = model.getFirstName();
        entity.lastName = model.getLastName();
        entity.createdAt = model.getCreatedAt();
        return entity;
    }

    public YoungLifeUserModel toModel() {
        return YoungLifeUserModel.builder()
                .id(id)
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .createdAt(createdAt)
                .password(password)
                .build();
    }
}
