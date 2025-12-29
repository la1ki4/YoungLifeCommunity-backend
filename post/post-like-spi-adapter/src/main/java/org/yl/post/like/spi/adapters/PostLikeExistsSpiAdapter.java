package org.yl.post.like.spi.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yl.post.like.spi.PostLikeExistsSpi;
import org.yl.post.like.spi.repositories.JpaPostLikeRepository;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PostLikeExistsSpiAdapter implements PostLikeExistsSpi {
    private final JpaPostLikeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public boolean exists(UUID postId, UUID userId) {
        return repository.existsByPostIdAndUserId(postId, userId);
    }
}
