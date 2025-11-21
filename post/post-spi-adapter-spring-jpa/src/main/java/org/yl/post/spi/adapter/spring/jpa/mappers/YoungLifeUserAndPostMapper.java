package org.yl.post.spi.adapter.spring.jpa.mappers;

import org.yl.post.model.*;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifePostEntity;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifeUserEntity;

public class YoungLifeUserAndPostMapper {

    public static YoungLifeUserEntity toEntity(YoungLifeUserModel model) {
        if (model == null) return null;
        YoungLifeUserEntity entity = new YoungLifeUserEntity();
        entity.setId(model.getId());
        entity.setEmail(model.getEmail());
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setPassword(model.getPassword());
        entity.setCreatedAt(model.getCreatedAt());
        return entity;
    }

    public static YoungLifeUserModel toModel(YoungLifeUserEntity entity) {
        if (entity == null) return null;
        return YoungLifeUserModel.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .password(entity.getPassword())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public static YoungLifePostEntity toEntity(YoungLifePostModel model) {
        if (model == null) return null;
        YoungLifePostEntity entity = new YoungLifePostEntity();
        entity.setId(model.getId());
        entity.setFileName(model.getFileName());
        entity.setDescription(model.getDescription());
        entity.setFilePath(model.getFilePath());
        entity.setContentType(model.getContentType());
        entity.setUploadedAt(model.getUploadedAt());
        entity.setUser(toEntity(model.getUser()));
        return entity;
    }

    public static YoungLifePostModel toModel(YoungLifePostEntity entity) {
        if (entity == null) return null;
        return YoungLifePostModel.builder()
                .id(entity.getId())
                .fileName(entity.getFileName())
                .description(entity.getDescription())
                .filePath(entity.getFilePath())
                .contentType(entity.getContentType())
                .uploadedAt(entity.getUploadedAt())
                .user(toModel(entity.getUser()))
                .build();
    }
}
