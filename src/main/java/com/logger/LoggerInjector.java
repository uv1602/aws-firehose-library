package com.logger;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class LoggerInjector implements BeanPostProcessor {

    @Value("${firehose.logger.access-key}")
    private String accessKey;

    @Value("${firehose.logger.secret-key}")
    private String secretKey;

    @Value("${firehose.logger.token}")
    private String token;

    @Value("${spring.profiles.active}")
    private String profile;

    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName)
            throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectLogger.class) && field.getType().equals(FireHoseLogger.class)) {
                field.setAccessible(true);
                try {
                    field.set(bean, new FireHoseLogger(profile, accessKey, secretKey, token));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to inject FireHoseLogger", e);
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        return bean;
    }
}