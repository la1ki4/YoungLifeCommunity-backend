package org.yl.post.comment.spi.adapter.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yl.post.comment.spi.GetCommentsByPostSpi;
import org.yl.post.comment.spi.adapter.mappers.CommentMapper;
import org.yl.post.comment.spi.adapter.repository.JpaCommentRepository;
import org.yl.post.model.CommentModel;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetCommentByPostSpiAdapter implements GetCommentsByPostSpi {

    private final JpaCommentRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<CommentModel> getByPostId(UUID postId) {
        return repository.findByPostIdOrderByCreatedAtAsc(postId)
                .stream()
                .map(CommentMapper::toModel)
                .toList();
    }
}
