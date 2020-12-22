package com.knox.template.service.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 注册服务
 *
 * @author knox
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.knox.template")
@MapperScan(basePackages = "com.knox.template.commons.mapper")
public class ServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }

}
