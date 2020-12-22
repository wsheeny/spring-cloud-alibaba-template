package com.knox.template.search.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.knox.template.commons.domain.TbItemEntity;
import com.knox.template.commons.mapper.TbItemMapper;
import com.knox.template.search.service.ITbItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * item商品表 服务实现类
 * </p>
 *
 * @author knox
 * @since 2020-12-20
 */
@Service
public class TbItemServiceImpl extends ServiceImpl<TbItemMapper, TbItemEntity> implements ITbItemService {

}
