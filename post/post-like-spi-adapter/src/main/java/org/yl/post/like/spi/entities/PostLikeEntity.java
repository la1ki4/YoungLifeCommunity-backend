package org.yl.post.like.spi.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="yl_post_like")
public class PostLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "post_id")
    private UUID postId;
    @Column(name = "user_id")
    private UUID userId;
}
