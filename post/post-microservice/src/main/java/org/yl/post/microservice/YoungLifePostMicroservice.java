package org.yl.post.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.yl.post.api.AddYoungLifePostApi;
import org.yl.post.spi.AddYoungLifePostSpi;
import org.yl.post.usecase.AddYoungLifePostUseCase;

@SpringBootApplication(scanBasePackages = "org.yl.post")
@EnableJpaRepositories(basePackages = "org.yl.post.spi.adapter.spring.jpa")
@EntityScan(basePackages = "org.yl.post.spi.adapter.spring.jpa")
public class YoungLifePostMicroservice {
    public static void main(String[] args) {
        SpringApplication.run(YoungLifePostMicroservice.class, args);
    }

    @Bean
    public AddYoungLifePostApi addYoungLifePostApi(AddYoungLifePostSpi youngLifePostSpi){
        return new AddYoungLifePostUseCase(youngLifePostSpi);
    }
}
