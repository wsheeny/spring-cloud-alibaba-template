package com.tiny.service.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiny.entity.ums.TbUser;
import com.tiny.mapper.ums.TbUserMapper;
import com.tiny.service.user.service.ITbUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author knox
 * @since 2020-12-19
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

    @Override
    public TbUser getUserById(String id) {
        return baseMapper.getUserById(id);
    }
}
