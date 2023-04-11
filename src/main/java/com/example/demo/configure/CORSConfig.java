package com.example.demo.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 物联网工程系 ITAEM 唐奕泽
 * @Description
 * @date 2022/5/23 22:37
 */
@Configuration //声明当前类是一个配置类
@Slf4j
public class CORSConfig {
    @Bean
    public WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                log.info("初始化 跨域配置");
                registry.addMapping("/**")
                        .allowedHeaders("*")
                        .allowedOrigins("*")
                        .allowedMethods("*");
            }
        };
    }
}
