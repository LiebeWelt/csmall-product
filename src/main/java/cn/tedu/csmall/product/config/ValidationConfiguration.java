package cn.tedu.csmall.product.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;

@Slf4j
@Configuration
public class ValidationConfiguration {

    public ValidationConfiguration() {
        log.debug("创建配置类:ValidationConfiguration");
    }

    @Bean
    public javax.validation.Validator validator() {
        return Validation
                .byProvider(HibernateValidator.class)
                .configure() // 开始配置Validator
                .failFast(true) // 快速失败，即检查到错误就直接视为失败
                .buildValidatorFactory()
                .getValidator();
    }
}
