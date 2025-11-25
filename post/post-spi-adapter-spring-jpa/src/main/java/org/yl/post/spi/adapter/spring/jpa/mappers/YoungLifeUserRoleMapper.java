package org.yl.post.spi.adapter.spring.jpa.mappers;

import org.yl.post.data.YoungLifeUserRoleData;
import org.yl.post.model.YoungLifeUserRoleModel;
import org.yl.post.spi.adapter.spring.jpa.entities.YoungLifeUserRoleEntity;

public class YoungLifeUserRoleMapper {
    public static YoungLifeUserRoleEntity toUserRoleEntity(YoungLifeUserRoleModel model) {
        if (model == null) return null;
        YoungLifeUserRoleEntity entity = new YoungLifeUserRoleEntity();
        entity.setId(model.getId());
        entity.setRoleName(model.getRoleName());
        entity.setRolePriorityLevel(model.getRolePriority());
        return entity;
    }

    public static YoungLifeUserRoleData toUserRoleData(YoungLifeUserRoleModel model) {
        if (model == null) return null;
        return YoungLifeUserRoleData.builder()
                .roleName(model.getRoleName())
                .build();
    }

    public static YoungLifeUserRoleModel toUserRoleModel(YoungLifeUserRoleEntity entity) {
        if (entity == null) return null;
        return YoungLifeUserRoleModel.builder()
                .id(entity.getId())
                .roleName(entity.getRoleName())
                .rolePriority(entity.getRolePriorityLevel())
                .build();
    }
}
