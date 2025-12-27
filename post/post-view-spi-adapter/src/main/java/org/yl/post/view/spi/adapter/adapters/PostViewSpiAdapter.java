package org.yl.post.view.spi.adapter.adapters;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yl.post.view.spi.PostViewSpi;
import org.yl.post.view.spi.adapter.entities.PostViewEntity;
import org.yl.post.view.spi.adapter.repositories.JpaPostViewRepository;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PostViewSpiAdapter implements PostViewSpi {
    private final JpaPostViewRepository repository;

    @Override
    @Transactional
    public boolean addViewIfNotExists(UUID userId, UUID postId) {
        if (repository.existsByUserIdAndPostId(userId, postId)) {
            return false;
        }

        PostViewEntity e = new PostViewEntity();
        e.setUserId(userId);
        e.setPostId(postId);

        try {
            repository.save(e);
            return true;
        } catch (DataIntegrityViolationException ex) {
            return false;
        }
    }
}
