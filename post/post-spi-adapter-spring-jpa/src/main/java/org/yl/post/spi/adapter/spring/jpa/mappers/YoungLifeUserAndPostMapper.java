package org.yl.post.spi.adapter.spring.jpa.mappers;

import org.yl.post.data.YoungLifePostData;
import org.yl.post.data.YoungLifeUserData;
import org.yl.post.model.*;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifePostEntity;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifeUserEntity;

public class YoungLifeUserAndPostMapper {

    public static YoungLifeUserEntity toUserEntity(YoungLifeUserModel model) {
        if (model == null) return null;
        YoungLifeUserEntity entity = new YoungLifeUserEntity();
        entity.setId(model.getId());
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setEmail(model.getEmail());
        entity.setPassword(model.getPassword());
        entity.setUserRole(YoungLifeUserRoleMapper.toUserRoleEntity(model.getUserRole()));
        return entity;
    }

    public static YoungLifeUserModel toUserModel(YoungLifeUserEntity entity) {
        if (entity == null) return null;
        return YoungLifeUserModel.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .userRole(YoungLifeUserRoleMapper.toUserRoleModel(entity.getUserRole()))
                .build();
    }

    public static YoungLifeUserData toUserData(YoungLifeUserModel model) {
        if (model == null) return null;
        return YoungLifeUserData.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .userRole(YoungLifeUserRoleMapper.toUserRoleData(model.getUserRole()))
                .build();
    }

    public static YoungLifePostEntity toPostEntity(YoungLifePostModel model) {
        if (model == null) return null;
        YoungLifePostEntity entity = new YoungLifePostEntity();
        entity.setId(model.getId());
        entity.setFileName(model.getFileName());
        entity.setDescription(model.getDescription());
        entity.setContentType(model.getContentType());
        entity.setFilePath(model.getFilePath());
        entity.setUploadedAt(model.getUploadedAt());
        entity.setUser(toUserEntity(model.getUser()));
        return entity;
    }

    public static YoungLifePostData toPostData(YoungLifePostModel model) {
        if (model == null) return null;
        return YoungLifePostData.builder()
                .user(toUserData(model.getUser()))
                .description(model.getDescription())
                .filePath(model.getFilePath())
                .build();
    }

    public static YoungLifePostModel toPostModel(YoungLifePostEntity entity) {
        if (entity == null) return null;
        return YoungLifePostModel.builder()
                .id(entity.getId())
                .fileName(entity.getFileName())
                .contentType(entity.getContentType())
                .filePath(entity.getFilePath())
                .description(entity.getDescription())
                .user(toUserModel(entity.getUser()))
                .build();
    }
}
