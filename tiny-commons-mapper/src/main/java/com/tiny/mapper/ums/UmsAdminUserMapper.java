package com.tiny.mapper.ums;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiny.entity.ums.UmsAdminUser;
import com.tiny.entity.ums.UmsResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户DAO
 *
 * @author knox
 * @since 2021-01-09
 */
@Mapper
@Repository
public interface UmsAdminUserMapper extends BaseMapper<UmsAdminUser> {

    /**
     * 用户可访问资源列表
     *
     * @param userId 用户ID
     * @return
     */
    List<UmsResource> getResourceList(@Param("userId") String userId);
}
