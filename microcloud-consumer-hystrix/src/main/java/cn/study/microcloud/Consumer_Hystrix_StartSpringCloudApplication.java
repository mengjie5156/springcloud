package cn.study.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@ComponentScan("cn.study.service,cn.study.microcloud")
@EnableFeignClients(basePackages={"cn.study.service"})//进行接口IDeptClientService的扫描生成使得可以注入到ConsumerDeptController里面
public class Consumer_Hystrix_StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_Hystrix_StartSpringCloudApplication.class,
                args);
    }
}