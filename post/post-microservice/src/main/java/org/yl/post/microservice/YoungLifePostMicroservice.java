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
import org.yl.post.spi.AddYoungLifePostSpi;
import org.yl.post.spi.ReceiveYoungLifePostSpi;
import org.yl.post.spi.YoungLifeUserByEmailSpi;
import org.yl.post.usecase.AddYoungLifePostUseCase;
import org.yl.post.usecase.ReceiveAllYoungLifePostsUseCase;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication(scanBasePackages = "org.yl.post")
@EnableJpaRepositories(basePackages = "org.yl.post.spi.adapter.spring.jpa")
@EnableFeignClients
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@EntityScan(basePackages = "org.yl.post.spi.adapter.spring.jpa")
public class YoungLifePostMicroservice {
    public static void main(String[] args) {
        SpringApplication.run(YoungLifePostMicroservice.class, args);
    }

    @Bean
    public AddYoungLifePostApi addYoungLifePostApi(AddYoungLifePostSpi postRepository, YoungLifeUserByEmailSpi userRepository){
        return new AddYoungLifePostUseCase(postRepository,userRepository);
    }

    @Bean
    public ReceiveAllYoungLifePostsApi receiveAllYoungLifePostsApi(ReceiveYoungLifePostSpi postRepository){
        return new ReceiveAllYoungLifePostsUseCase(postRepository);
    }
}
