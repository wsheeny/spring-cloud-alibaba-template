package com.knox.template.commons.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.knox.template.commons.domain.TbItemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * item商品表 Mapper 接口
 * </p>
 *
 * @author knox
 * @since 2020-12-20
 */
@Mapper
@Repository
public interface TbItemMapper extends BaseMapper<TbItemEntity> {

}
