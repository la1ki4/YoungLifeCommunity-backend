package org.yl.post.spi.adapter.spring.jpa.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.yl.post.model.YoungLifePostModel;
import org.yl.post.spi.ReceiveYoungLifePostSpi;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifePostEntity;
import org.yl.post.spi.adapter.spring.jpa.mappers.YoungLifeUserAndPostMapper;
import org.yl.post.spi.adapter.spring.jpa.repositories.JpaYoungLifePostRepository;

@Component
@RequiredArgsConstructor
public class ReceiveYoungLifePostSpiAdapter implements ReceiveYoungLifePostSpi {
    private final JpaYoungLifePostRepository youngLifePostRepository;

    @Override
    public Page<YoungLifePostModel> getFeedYoungLifePosts(int page, int size) {
        Page<YoungLifePostEntity> postEntities = youngLifePostRepository.findAll(PageRequest.of(page, size, Sort.by("uploadedAt").descending()));
        return postEntities.map(YoungLifeUserAndPostMapper::toPostModel);
    }
}
