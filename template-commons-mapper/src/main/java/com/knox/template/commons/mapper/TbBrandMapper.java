package com.knox.template.commons.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.knox.template.commons.domain.TbBrandEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 品牌表 Mapper 接口
 * </p>
 *
 * @author knox
 * @since 2020-12-20
 */
@Mapper
@Repository
public interface TbBrandMapper extends BaseMapper<TbBrandEntity> {

}
