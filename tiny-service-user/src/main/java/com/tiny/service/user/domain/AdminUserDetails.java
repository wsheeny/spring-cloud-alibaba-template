package com.tiny.service.user.domain;

import com.tiny.entity.ums.UmsAdminUser;
import com.tiny.entity.ums.UmsResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户登录数据
 *
 * @author knox
 * @since 2021-01-09
 */
public class AdminUserDetails implements UserDetails {

    private final UmsAdminUser umsAdminUser;
    private final List<UmsResource> resourceList;

    public AdminUserDetails(UmsAdminUser umsAdminUser, List<UmsResource> resourceList) {
        this.umsAdminUser = umsAdminUser;
        this.resourceList = resourceList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return resourceList.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId() + ":" + role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdminUser.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdminUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return umsAdminUser.getStatus();
    }
}
