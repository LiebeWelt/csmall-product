package cn.tedu.csmall.product.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.csmall.product.mapper")
public class MybatisConfiguration {
    public MybatisConfiguration() {
        System.out.println("创建配置类：MybatisConfiguration");
    }
}
