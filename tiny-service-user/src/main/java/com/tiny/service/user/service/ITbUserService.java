package com.tiny.service.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tiny.entity.ums.TbUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author knox
 * @since 2020-12-19
 */
public interface ITbUserService extends IService<TbUser> {

    /**
     * 获取用户
     *
     * @param id 用户ID
     * @return
     */
    TbUser getUserById(String id);
}
