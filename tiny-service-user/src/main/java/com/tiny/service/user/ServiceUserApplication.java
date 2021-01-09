package com.tiny.service.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 注册服务
 *
 * @author knox
 */
@EnableDiscoveryClient // 服务注册
@SpringBootApplication(scanBasePackages = "com.tiny")
@MapperScan(basePackages = "com.tiny.mapper")
public class ServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }

}
