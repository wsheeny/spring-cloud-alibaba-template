package com.tiny.service.user.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tiny.entity.ums.UmsAdminUser;
import com.tiny.entity.ums.UmsResource;
import com.tiny.security.config.SpringSecurityConfig;
import com.tiny.service.user.domain.AdminUserDetails;
import com.tiny.service.user.service.IUmsAdminUserService;
import com.tiny.service.user.service.IUmsResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务Security配置
 *
 * @author knox
 * @since 2021-01-09
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TinySpringSecurityConfig extends SpringSecurityConfig {

    @Resource
    private IUmsAdminUserService iUmsAdminUserService;
    @Resource
    private IUmsResourceService iUmsResourceService;

    /**
     * 重写 UserDetailsService
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return username -> {
            // 获取登录用户信息
            UmsAdminUser admin = iUmsAdminUserService.getOne(new LambdaQueryWrapper<UmsAdminUser>().eq(UmsAdminUser::getUsername, username));
            if (admin != null) {
                // 获取用户可访问资源
                List<UmsResource> resourceList = iUmsResourceService.getResourceList();
                return new AdminUserDetails(admin, resourceList);
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }
}
