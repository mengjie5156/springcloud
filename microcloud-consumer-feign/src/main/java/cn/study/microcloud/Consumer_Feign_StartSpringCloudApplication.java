package cn.study.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages={"cn.study.service"})//进行接口IDeptClientService的扫描生成使得可以注入到ConsumerDeptController里面
public class Consumer_Feign_StartSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_Feign_StartSpringCloudApplication.class,
                args);
    }
}