package com.tiny.service.search.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tiny.commons.domain.TbItemEntity;
import com.tiny.commons.mapper.TbItemMapper;
import com.tiny.service.search.service.ITbItemService;
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
