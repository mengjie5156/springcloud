package cn.study.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Dept_8002_StartSpringCloudApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(Dept_8002_StartSpringCloudApplication.class, args);
    }

}
