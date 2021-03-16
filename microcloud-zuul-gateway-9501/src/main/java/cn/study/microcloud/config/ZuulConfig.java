package cn.study.microcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.study.microcloud.filter.AuthorizedRequestFilter;

@Configuration
public class ZuulConfig {
    @Bean
    public AuthorizedRequestFilter getAuthorizedRequestFilter() {
        return new AuthorizedRequestFilter() ;
    }
}