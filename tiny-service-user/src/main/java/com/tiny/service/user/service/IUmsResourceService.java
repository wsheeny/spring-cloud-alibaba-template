package com.tiny.service.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tiny.entity.ums.UmsResource;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务类
 * </p>
 *
 * @author knox
 * @since 2021-01-09
 */
public interface IUmsResourceService extends IService<UmsResource> {

    /**
     * 可访问资源列表
     *
     * @return
     */
    List<UmsResource> getResourceList();

}
