package org.yl.post.comment.spi.adapter.adapters;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.yl.post.comment.spi.AddCommentSpi;
import org.yl.post.comment.spi.adapter.mappers.CommentMapper;
import org.yl.post.comment.spi.adapter.repository.JpaCommentRepository;
import org.yl.post.model.CommentModel;

@Component
@AllArgsConstructor
public class AddCommentSpiAdapter implements AddCommentSpi {

    private final JpaCommentRepository repository;

    @Override
    @Transactional
    public CommentModel addComment(CommentModel commentModel) {
        var savedComment = repository.save(CommentMapper.toEntity(commentModel));
        return CommentMapper.toModel(savedComment);
    }
}
