package com.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.springcloud.dao")
@EnableEurekaClient  //当前项目需要启用Eureka服务器
public class SpringCloudOrdersProvider {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrdersProvider.class, args);

	}

}
