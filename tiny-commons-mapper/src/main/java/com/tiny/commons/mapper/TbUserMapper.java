package com.tiny.commons.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tiny.commons.domain.TbUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author knox
 * @since 2020-12-20
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUserEntity> {

}
