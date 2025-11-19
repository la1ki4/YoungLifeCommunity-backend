package org.yl.post.spi.adapter.spring.jpa.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.post.model.YoungLifePostModel;
import org.yl.post.spi.ReceiveYoungLifePostSpi;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifePostEntity;
import org.yl.post.spi.adapter.spring.jpa.mappers.YoungLifeUserAndPostMapper;
import org.yl.post.spi.adapter.spring.jpa.repositories.JpaYoungLifePostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReceiveYoungLifePostSpiAdapter implements ReceiveYoungLifePostSpi {
    private final JpaYoungLifePostRepository youngLifePostRepository;

    @Override
    public Optional<List<YoungLifePostModel>> getAllYoungLifePosts() {
        List<YoungLifePostEntity> postEntities = youngLifePostRepository.findAll();
        List<YoungLifePostModel> postModels = new ArrayList<>();
        for (YoungLifePostEntity postEntity : postEntities) {
            postModels.add(YoungLifeUserAndPostMapper.toModel(postEntity));
        }
        return Optional.of(postModels);
    }
}
