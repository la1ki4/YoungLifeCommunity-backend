package org.yl.post.spi.adapter.spring.jpa.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.post.model.YoungLifePostModel;
import org.yl.post.spi.AddYoungLifePostSpi;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifePostEntity;
import org.yl.post.spi.adapter.spring.jpa.mappers.YoungLifeUserAndPostMapper;
import org.yl.post.spi.adapter.spring.jpa.repositories.JpaYoungLifePostRepository;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AddYoungLifePostSpiAdapter implements AddYoungLifePostSpi {

    private JpaYoungLifePostRepository youngLifePostRepository;

    @Override
    public Optional<YoungLifePostModel> addYoungLifePostSpi(YoungLifePostModel postModel) {
        YoungLifePostEntity postEntity = YoungLifeUserAndPostMapper.toPostEntity(postModel);
        YoungLifePostEntity savedPost = youngLifePostRepository.save(postEntity);
        return Optional.of(YoungLifeUserAndPostMapper.toPostModel(savedPost));
    }
}
