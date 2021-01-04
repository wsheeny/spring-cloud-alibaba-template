package com.tiny.service.search.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiny.commons.domain.TbBrandEntity;
import com.tiny.commons.mapper.TbBrandMapper;
import com.tiny.service.search.service.ITbBrandService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author knox
 * @since 2020-12-20
 */
@Service
public class TbBrandServiceImpl extends ServiceImpl<TbBrandMapper, TbBrandEntity> implements ITbBrandService {

}
