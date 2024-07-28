package com.logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {

    @Value("${firehose.logger.access-key}")
    private String accessKey;

    @Value("${firehose.logger.secret-key}")
    private String secretKey;

    @Value("${firehose.logger.token}")
    private String token;

    @Value("${spring.profiles.active}")
    private String profile;

    @Bean
    public FireHoseLogger fireHoseLogger() {
        return new FireHoseLogger(profile, accessKey, secretKey, token);
    }
}
