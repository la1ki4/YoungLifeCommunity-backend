package org.yl.YoungLifeCommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.yl.YoungLifeCommunity.repositories")
@PropertySource("classpath:properties/application.properties")
@PropertySource("classpath:properties/db_connection.properties")
public class YoungLifeCommunityApplication {
    public static void main(String[] args) {
        SpringApplication.run(YoungLifeCommunityApplication.class, args);
    }
}
