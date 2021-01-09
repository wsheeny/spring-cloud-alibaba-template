package com.tiny.service.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiny.entity.ums.UmsResource;
import com.tiny.mapper.ums.UmsResourceMapper;
import com.tiny.service.user.service.IUmsResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务实现类
 * </p>
 *
 * @author knox
 * @since 2021-01-09
 */
@Service
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceMapper, UmsResource> implements IUmsResourceService {

    @Override
    public List<UmsResource> getResourceList() {
        return null;
    }
}
