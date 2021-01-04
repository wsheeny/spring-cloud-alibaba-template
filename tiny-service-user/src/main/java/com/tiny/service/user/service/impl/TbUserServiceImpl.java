package com.tiny.service.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiny.commons.domain.TbUserEntity;
import com.tiny.commons.mapper.TbUserMapper;
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
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUserEntity> implements ITbUserService {

}
