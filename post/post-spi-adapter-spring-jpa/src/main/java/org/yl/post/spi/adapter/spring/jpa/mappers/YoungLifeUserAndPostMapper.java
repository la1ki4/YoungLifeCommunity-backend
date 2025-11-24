package org.yl.post.spi.adapter.spring.jpa.mappers;

import org.yl.post.model.*;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifePostEntity;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifeUserEntity;

public class YoungLifeUserAndPostMapper {

    public static YoungLifeUserEntity toUserEntity(YoungLifeUserModel model) {
        if (model == null) return null;
        YoungLifeUserEntity entity = new YoungLifeUserEntity();
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setUserRole(YoungLifeUserRoleMapper.toUserRoleEntity(model.getUserRole()));
        return entity;
    }

    public static YoungLifeUserModel toUserModel(YoungLifeUserEntity entity) {
        if (entity == null) return null;
        return YoungLifeUserModel.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .userRole(YoungLifeUserRoleMapper.toUserRoleModel(entity.getUserRole()))
                .build();
    }

    public static YoungLifePostEntity toPostEntity(YoungLifePostModel model) {
        if (model == null) return null;
        YoungLifePostEntity entity = new YoungLifePostEntity();
        entity.setFileName(model.getFileName());
        entity.setDescription(model.getDescription());
        entity.setFilePath(model.getFilePath());
        entity.setUser(toUserEntity(model.getUser()));
        return entity;
    }

    public static YoungLifePostModel toPostModel(YoungLifePostEntity entity) {
        if (entity == null) return null;
        return YoungLifePostModel.builder()
                .fileName(entity.getFileName())
                .filePath(entity.getFilePath())
                .description(entity.getDescription())
                .user(toUserModel(entity.getUser()))
                .build();
    }
}
