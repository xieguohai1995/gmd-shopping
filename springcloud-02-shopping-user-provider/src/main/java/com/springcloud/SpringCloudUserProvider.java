package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //当前项目需要启用Eureka服务器
public class SpringCloudUserProvider {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudUserProvider.class, args);

	}

}
