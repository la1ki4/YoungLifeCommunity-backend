package org.yl.post.like.spi.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.post.like.spi.PostLikeCountSpi;
import org.yl.post.like.spi.repositories.JpaPostLikeRepository;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PostLikeCountSpiAdapter implements PostLikeCountSpi {

    private final JpaPostLikeRepository repository;

    @Override
    public long countLikes(UUID postId) {
        return repository.countByPostId(postId);
    }
}
