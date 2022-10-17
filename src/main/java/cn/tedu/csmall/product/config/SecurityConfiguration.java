package cn.tedu.csmall.product.config;

import cn.tedu.csmall.product.filter.JwtAuthorizationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security的配置类
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Slf4j
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 【配置白名单】
        // 在配置路径时，星号是通配符
        // 1个星号只能匹配任何文件夹或文件的名称，但不能跨多个层级
        // 例如：/*/test.js，可以匹配到 /a/test.js 和 /b/test.js，但不可以匹配到 /a/b/test.js
        // 2个连续的星号可以匹配若干个文件夹的层级
        // 例如：/**/test.js，可以匹配 /a/test.js 和 /b/test.js 和 /a/b/test.js
        String[] urls = {
                "/doc.html",
                "/**/*.js",
                "/**/*.css",
                "/swagger-resources",
                "/v2/api-docs"
        };

        http.csrf().disable(); // 禁用CSRF（防止伪造的跨域攻击）

        http.cors(); // 启用Spring Security框架的处理跨域的过滤器，此过滤器将放行跨域请求，包括预检的OPTIONS请求

        http.authorizeRequests() // 对请求执行认证与授权
                // .antMatchers(urls) // 匹配某些请求路径，必须严格匹配路径
                .mvcMatchers(urls) // 匹配某些请求路径，匹配路径时不关心扩展名，例如配置的路径是 /admin，则可以匹配上 /admin、/admin.html、/admin.jpg
                .permitAll() // （对此前匹配的请求路径）不需要通过认证即允许访问
                .anyRequest() // 除以上配置过的请求路径以外的所有请求路径
                .authenticated(); // 要求是已经通过认证的

        // http.formLogin(); // 开启表单验证，即视为未通过认证时，将重定向到登录表单，如果无此配置，则直接响应403

        // 将自定义的JWT过滤器添加在Spring Security框架内置的过滤器之前
        http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Autowired
    JwtAuthorizationFilter jwtAuthorizationFilter;

}
