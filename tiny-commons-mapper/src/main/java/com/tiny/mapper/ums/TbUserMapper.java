package com.tiny.mapper.ums;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiny.entity.ums.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author knox
 * @since 2021-01-07
 */
@Mapper
@Repository
public interface TbUserMapper extends BaseMapper<TbUser> {

    /**
     * 获取用户
     * @param id 用户ID
     * @return
     */
    TbUser getUserById(@Param("id") String id);
}
