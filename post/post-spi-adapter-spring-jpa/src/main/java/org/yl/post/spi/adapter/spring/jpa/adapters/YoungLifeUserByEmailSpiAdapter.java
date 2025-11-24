package org.yl.post.spi.adapter.spring.jpa.adapters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.post.model.YoungLifeUserModel;
import org.yl.post.spi.YoungLifeUserByEmailSpi;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifeUserEntity;
import org.yl.post.spi.adapter.spring.jpa.mappers.YoungLifeUserAndPostMapper;
import org.yl.post.spi.adapter.spring.jpa.repositories.JpaYoungLifeUserRepository;

import java.util.Optional;

@Component
@AllArgsConstructor
public class YoungLifeUserByEmailSpiAdapter implements YoungLifeUserByEmailSpi {
    JpaYoungLifeUserRepository userRepository;

    @Override
    public YoungLifeUserModel getYoungLifeUserByEmail(String userEmail) {
        Optional<YoungLifeUserEntity> user = userRepository.findByEmail(userEmail);
        if(user.isEmpty()){
            throw new RuntimeException("User have not found by email");
        }
        return YoungLifeUserAndPostMapper.toUserModel(user.get());
    }
}
