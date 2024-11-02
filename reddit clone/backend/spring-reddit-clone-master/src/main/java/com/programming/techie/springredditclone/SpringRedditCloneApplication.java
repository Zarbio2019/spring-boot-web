package com.programming.techie.springredditclone;

import com.programming.techie.springredditclone.config.OpenAPIConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // used to send emails asynchronously (instead of using a Message Queue like RabbitMQ)
@Import(OpenAPIConfiguration.class)
public class SpringRedditCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.programming.techie.springredditclone.SpringRedditCloneApplication.class, args);
    }

}
