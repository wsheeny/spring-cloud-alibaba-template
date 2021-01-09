package com.tiny.service.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tiny.entity.ums.UmsAdminUser;
import com.tiny.entity.ums.UmsResource;
import com.tiny.service.user.model.dto.UmsAdminUserRegisterDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author knox
 * @since 2021-01-09
 */
public interface IUmsAdminUserService extends IService<UmsAdminUser> {

    /**
     * 获取用户数据
     *
     * @param username 用户名
     * @return
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 获取可访问资源列表
     *
     * @param userId
     * @return 用户ID
     */
    List<UmsResource> getResourceList(String userId);

    /**
     * 用户注册
     *
     * @param dto 注册DTO
     * @return
     */
    UmsAdminUser register(UmsAdminUserRegisterDTO dto);

}
