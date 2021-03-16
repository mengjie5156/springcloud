package cn.study.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;
import feign.Logger;
@Configuration
public class FeignClientConfig {
    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return feign.Logger.Level.FULL ;
    }

    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("zdmin", "studyjava");
    }
}