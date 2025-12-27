package org.yl.post.view.spi.adapter.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.post.view.spi.PostViewCountSpi;
import org.yl.post.view.spi.adapter.repositories.JpaPostViewRepository;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PostViewCountSpiAdapter implements PostViewCountSpi {

    private final JpaPostViewRepository repository;

    @Override
    public long countViews(UUID postId) {
        return repository.countByPostId(postId);
    }
}
