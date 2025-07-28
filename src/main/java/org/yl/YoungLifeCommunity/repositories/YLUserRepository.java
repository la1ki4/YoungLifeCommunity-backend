package org.yl.YoungLifeCommunity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yl.YoungLifeCommunity.entities.YLUserEntity;

import java.util.List;
import java.util.UUID;


public interface YLUserRepository extends JpaRepository<YLUserEntity, UUID> {
    List<YLUserEntity> findAll();
}
