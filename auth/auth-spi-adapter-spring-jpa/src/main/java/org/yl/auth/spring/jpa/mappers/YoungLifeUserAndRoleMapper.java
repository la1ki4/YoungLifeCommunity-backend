package org.yl.auth.spring.jpa.mappers;

import org.yl.auth.model.YoungLifeUserModel;
import org.yl.auth.model.YoungLifeUserRoleModel;
import org.yl.auth.spring.jpa.entities.YoungLifeUserEntity;
import org.yl.auth.spring.jpa.entities.YoungLifeUserRoleEntity;

public class YoungLifeUserAndRoleMapper {

    public static YoungLifeUserEntity fromUserModel(YoungLifeUserModel model) {
        YoungLifeUserEntity entity = new YoungLifeUserEntity();
        entity.setEmail(model.getEmail());
        entity.setPassword(model.getPassword());
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setCreatedAt(model.getCreatedAt());
        return entity;
    }

    public static YoungLifeUserModel toUserModel(YoungLifeUserEntity entity) {
        if (entity == null) {
            return null;
        }
        return YoungLifeUserModel.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .createdAt(entity.getCreatedAt())
                .password(entity.getPassword())
                .build();
    }

    public static YoungLifeUserRoleEntity fromUserRoleModel(YoungLifeUserRoleModel model) {
        YoungLifeUserRoleEntity entity = new YoungLifeUserRoleEntity();
        entity.setId(model.getId());
        entity.setRoleName(model.getRoleName());
        entity.setRolePriorityLevel(model.getRolePriorityLevel());
        return entity;
    }

    public static YoungLifeUserRoleModel toUserRoleModel(YoungLifeUserRoleModel entity){
        if (entity == null) {
            return null;
        }
        return YoungLifeUserRoleModel.builder()
                .id(entity.getId())
                .roleName(entity.getRoleName())
                .rolePriorityLevel(entity.getRolePriorityLevel())
                .build();
    }
}
