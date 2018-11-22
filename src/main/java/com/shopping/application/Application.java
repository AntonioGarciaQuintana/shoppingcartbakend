package com.shopping.application;

import com.shopping.application.configuration.WebConfiguration;
import com.shopping.application.configuration.WebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(value = {"com.shopping.entities"})
@EnableJpaRepositories(repositoryImplementationPostfix = "", basePackages = {"com.shopping.repositories"})
@ComponentScan(value = {"com.shopping"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
