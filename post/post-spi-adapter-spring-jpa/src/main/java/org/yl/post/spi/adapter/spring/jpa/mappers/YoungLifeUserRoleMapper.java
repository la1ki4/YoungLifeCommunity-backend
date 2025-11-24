package org.yl.post.spi.adapter.spring.jpa.mappers;

import org.yl.post.model.YoungLifeUserRoleModel;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifeUserRoleEntity;

public class YoungLifeUserRoleMapper {
    public static YoungLifeUserRoleEntity toUserRoleEntity(YoungLifeUserRoleModel model) {
        if (model == null) return null;
        YoungLifeUserRoleEntity entity = new YoungLifeUserRoleEntity();
        entity.setRoleName(model.getRoleName());
        return entity;
    }

    public static YoungLifeUserRoleModel toUserRoleModel(YoungLifeUserRoleEntity entity) {
        if (entity == null) return null;
        return YoungLifeUserRoleModel.builder()
                .roleName(entity.getRoleName())
                .build();
    }
}
