package org.yl.post.spi.adapter.spring.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="yl_post")
public class YoungLifePostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "post_id")
    private UUID id;
    @Column(name = "description")
    private String description;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "file_data")
    @Lob
    private byte[] fileData;
    @Column(name = "uploaded_at")
    private LocalDateTime uploadedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private YoungLifeUserEntity user;
}
