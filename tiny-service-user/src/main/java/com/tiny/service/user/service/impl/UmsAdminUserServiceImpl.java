package com.tiny.service.user.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiny.commons.exception.Asserts;
import com.tiny.entity.ums.UmsAdminUser;
import com.tiny.entity.ums.UmsResource;
import com.tiny.mapper.ums.UmsAdminUserMapper;
import com.tiny.service.user.domain.AdminUserDetails;
import com.tiny.service.user.model.dto.UmsAdminUserRegisterDTO;
import com.tiny.service.user.service.IUmsAdminUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author knox
 * @since 2021-01-09
 */
@Service
public class UmsAdminUserServiceImpl extends ServiceImpl<UmsAdminUserMapper, UmsAdminUser> implements IUmsAdminUserService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        UmsAdminUser admin = baseMapper.selectOne(new LambdaQueryWrapper<UmsAdminUser>().eq(UmsAdminUser::getUsername, username));
        if (admin != null) {
            // 获取用户可访问资源
            List<UmsResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin, resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public List<UmsResource> getResourceList(String userId) {
        // List<UmsResource> resourceList = adminCacheService.getResourceList(userId);
        // if (CollUtil.isNotEmpty(resourceList)) {
        //     return resourceList;
        // }
        // resourceList = adminRoleRelationDao.getResourceList(userId);
        // if (CollUtil.isNotEmpty(resourceList)) {
        //     adminCacheService.setResourceList(userId, resourceList);
        // }
        return null;
    }

    @Override
    public UmsAdminUser register(UmsAdminUserRegisterDTO dto) {
        // 查询是否有相同用户名的用户
        QueryWrapper<UmsAdminUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UmsAdminUser::getUsername, dto.getUsername());
        List<UmsAdminUser> umsAdminUserList = list(wrapper);
        if (umsAdminUserList.size() > 0) {
            Asserts.fail("帐号已存在");
        }

        // 数据封装
        UmsAdminUser umsAdminUser = new UmsAdminUser();
        BeanUtils.copyProperties(dto, umsAdminUser);
        umsAdminUser.setAlias("用户" + RandomUtil.randomString(8).toUpperCase());
        umsAdminUser.setCreateTime(new Date()).setStatus(true);

        // 将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdminUser.getPassword());
        umsAdminUser.setPassword(encodePassword);
        baseMapper.insert(umsAdminUser);
        // 不返回敏感数据
        umsAdminUser.setPassword("");
        return umsAdminUser;
    }
}
