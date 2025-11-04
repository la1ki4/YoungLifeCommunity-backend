package org.yl.post.spi.adapter.spring.jpa;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.post.model.YoungLifePostModel;
import org.yl.post.spi.AddYoungLifePostSpi;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AddYoungLifePostSpiAdapter implements AddYoungLifePostSpi {

    private JpaYoungLifePostRepository youngLifePostRepository;

    @Override
    public Optional<YoungLifePostModel> addYoungLifePostSpi(YoungLifePostModel postData) {
        YoungLifePostEntity post = YoungLifePostEntity.fromModel(postData);
        YoungLifePostEntity saved = youngLifePostRepository.save(post);
        return Optional.of(saved.toModel());
    }
}
