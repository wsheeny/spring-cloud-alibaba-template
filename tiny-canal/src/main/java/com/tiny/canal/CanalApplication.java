package com.tiny.canal;

import com.tiny.canal.config.CanalClientConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * Canal监控要保持一直运行
 *
 * @author knox
 */
@SpringBootApplication
public class CanalApplication implements CommandLineRunner {

    @Resource
    CanalClientConfig canalClientConfig;

    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 执行canal监听
        canalClientConfig.run();
    }
}
