package com.knox.template.search.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.knox.template.search.service.ITbBrandService;
import com.knox.template.commons.domain.TbBrandEntity;
import com.knox.template.commons.mapper.TbBrandMapper;
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
