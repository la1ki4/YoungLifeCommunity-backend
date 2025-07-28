package org.yl.YoungLifeCommunity.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.yl.YoungLifeCommunity.entities.YLUserEntity;
import org.yl.YoungLifeCommunity.repositories.YLUserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class YLUserService {
    private final YLUserRepository ylUserRepository;

    public Optional<List<YLUserEntity>> getAllYLUsers(){
        return Optional.of(ylUserRepository.findAll());
    }
}
