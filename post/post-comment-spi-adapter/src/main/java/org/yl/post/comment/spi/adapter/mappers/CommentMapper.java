package org.yl.post.comment.spi.adapter.mappers;


import org.yl.post.comment.spi.adapter.entities.CommentEntity;
import org.yl.post.model.CommentModel;

public class CommentMapper {

    public static CommentEntity toEntity(CommentModel model) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(model.getId());
        commentEntity.setPostId(model.getPostId());
        commentEntity.setUserId(model.getUserId());
        commentEntity.setComment(model.getComment());
        commentEntity.setCreatedAt(model.getCreatedAt());
        return commentEntity;
    }

    public static CommentModel toModel(CommentEntity commentEntity) {
        return CommentModel.builder()
                .id(commentEntity.getId())
                .postId(commentEntity.getPostId())
                .userId(commentEntity.getUserId())
                .comment(commentEntity.getComment())
                .createdAt(commentEntity.getCreatedAt())
                .build();
    }
}
