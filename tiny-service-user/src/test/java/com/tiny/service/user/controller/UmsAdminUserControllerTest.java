package com.tiny.service.user.controller;

import com.tiny.security.config.IgnoreUrlsConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UmsAdminUserControllerTest {

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Test
    void t() {
        System.out.println(ignoreUrlsConfig.getUrls());
    }

}
