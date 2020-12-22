package com.knox.template.search;

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
@SpringBootApplication(scanBasePackages = "com.knox.template")
@MapperScan(basePackages = "com.knox.template.commons.mapper")
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

}
