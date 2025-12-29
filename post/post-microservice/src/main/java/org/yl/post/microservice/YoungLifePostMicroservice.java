package org.yl.post.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.yl.post.api.AddYoungLifePostApi;
import org.yl.post.api.ReceiveAllYoungLifePostsApi;
import org.yl.post.comment.api.GetPostCommentsApi;
import org.yl.post.comment.api.PostCommentApi;
import org.yl.post.comment.api.PostCommentCountApi;
import org.yl.post.comment.spi.AddCommentSpi;
import org.yl.post.comment.spi.GetCommentsByPostSpi;
import org.yl.post.comment.spi.PostCommentCountSpi;
import org.yl.post.like.api.PostLikeCountApi;
import org.yl.post.like.api.ToggleLikeToPostApi;
import org.yl.post.like.spi.PostLikeCountSpi;
import org.yl.post.like.spi.PostLikeExistsSpi;
import org.yl.post.like.spi.PostLikeSpi;
import org.yl.post.spi.AddYoungLifePostSpi;
import org.yl.post.spi.ReceiveYoungLifePostSpi;
import org.yl.post.spi.YoungLifeUserByEmailSpi;
import org.yl.post.usecase.*;
import org.yl.post.view.api.PostViewApi;
import org.yl.post.view.spi.PostViewCountSpi;
import org.yl.post.view.spi.PostViewSpi;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication(scanBasePackages = "org.yl.post")
@EnableJpaRepositories(basePackages = {
        "org.yl.post.spi.adapter.spring.jpa",
        "org.yl.post.like.spi",
        "org.yl.post.comment.spi",
        "org.yl.post.view.spi"
})
@EnableFeignClients
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@EntityScan(basePackages = {
        "org.yl.post.spi.adapter.spring.jpa",
        "org.yl.post.like.spi",
        "org.yl.post.comment.spi",
        "org.yl.post.view.spi"
})
public class YoungLifePostMicroservice {
    public static void main(String[] args) {
        SpringApplication.run(YoungLifePostMicroservice.class, args);
    }

    @Bean
    public PostViewApi postViewApi(PostViewSpi postViewSpi,
                                   PostViewCountSpi postViewCountSpi,
                                   YoungLifeUserByEmailSpi userByEmailSpi) {
        return new AddPostViewUseCase(postViewSpi, postViewCountSpi, userByEmailSpi);
    }

    @Bean
    public PostCommentCountApi postCommentCountApi(PostCommentCountSpi postCommentCountSpi) {
        return new GetPostCommentCountUseCase(postCommentCountSpi);
    }

    @Bean
    public GetPostCommentsApi getPostCommentsApi(
            GetCommentsByPostSpi getCommentsByPostSpi,
            YoungLifeUserByEmailSpi userByIdSpi
    ) {
        return new GetPostCommentsUseCase(getCommentsByPostSpi, userByIdSpi);
    }


    @Bean
    public PostCommentApi postCommentApi(AddCommentSpi addCommentSpi, YoungLifeUserByEmailSpi userByEmailSpi) {
        return new AddPostCommentUseCase(addCommentSpi, userByEmailSpi);
    }

    @Bean
    public AddYoungLifePostApi addYoungLifePostApi(AddYoungLifePostSpi postRepository, YoungLifeUserByEmailSpi userRepository) {
        return new AddYoungLifePostUseCase(postRepository, userRepository);
    }

    @Bean
    public PostLikeCountApi postLikeCountApi(
            PostLikeCountSpi postLikeCountSpi,
            PostLikeExistsSpi postLikeExistsSpi,
            YoungLifeUserByEmailSpi userByEmailSpi
    ) {
        return new GetPostLikeCountUseCase(postLikeCountSpi, postLikeExistsSpi, userByEmailSpi);
    }


    @Bean
    public ReceiveAllYoungLifePostsApi receiveAllYoungLifePostsApi(ReceiveYoungLifePostSpi postRepository) {
        return new ReceiveAllYoungLifePostsUseCase(postRepository);
    }

    @Bean
    public ToggleLikeToPostApi postLikeApi(PostLikeSpi postLikeSpi,
                                           PostLikeCountSpi postLikeCountSpi,
                                           YoungLifeUserByEmailSpi userByEmailSpi) {
        return new ToggleYoungLifePostUseCase(postLikeSpi, postLikeCountSpi, userByEmailSpi);
    }
}
