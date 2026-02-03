package org.yl.calendar.event.spi.adapter.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="yl_users")
@Getter
@Setter
public class UserEntity {
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
    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRoleEntity userRole;
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.PERSIST)
    private List<CalendarEntity> eventData;
    @Column(name="created_at")
    private Timestamp createdAt;
}