package org.yl.post.comment.spi.adapter.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yl.post.comment.spi.PostCommentCountSpi;
import org.yl.post.comment.spi.adapter.repository.JpaCommentRepository;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PostCommentCountSpiAdapter implements PostCommentCountSpi {

    private final JpaCommentRepository repository;

    @Override
    @Transactional
    public long countByPostId(UUID postId) {
        return repository.countByPostId(postId);
    }
}
