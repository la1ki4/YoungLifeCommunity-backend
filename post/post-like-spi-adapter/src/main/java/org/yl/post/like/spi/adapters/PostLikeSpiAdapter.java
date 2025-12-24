package org.yl.post.like.spi.adapters;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.yl.post.like.spi.PostLikeSpi;
import org.yl.post.like.spi.entities.PostLikeEntity;
import org.yl.post.like.spi.repositories.JpaPostLikeRepository;
import org.yl.post.model.PostLikeModel;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class PostLikeSpiAdapter implements PostLikeSpi {

    private final JpaPostLikeRepository repository;

    @Override
    @Transactional
    public Optional<PostLikeModel> togglePostLike(PostLikeModel postLikeModel) {
        UUID postId = postLikeModel.getPostId();
        UUID userId = postLikeModel.getUserId();

        Optional<PostLikeEntity> existing = repository.findByPostIdAndUserId(postId, userId);
        if (existing.isPresent()) {
            repository.delete(existing.get());
            return Optional.empty();
        }

        PostLikeEntity entity = new PostLikeEntity();
        entity.setPostId(postId);
        entity.setUserId(userId);

        //protection against race condition
        try{
            PostLikeEntity saved = repository.save(entity);

            PostLikeModel result = PostLikeModel.builder()
                    .id(saved.getId())
                    .postId(saved.getPostId())
                    .userId(saved.getUserId())
                    .build();

            return Optional.of(result);
        } catch(DataIntegrityViolationException ex){
            return Optional.empty();
        }
    }
}
