package com.tiny.service.search;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 全文检索
 *
 * @author knox
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.tiny")
@MapperScan(basePackages = "com.tiny.commons.mapper")
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

}
