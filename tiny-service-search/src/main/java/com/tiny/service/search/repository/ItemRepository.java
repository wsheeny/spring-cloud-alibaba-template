package com.tiny.service.search.repository;

import com.tiny.commons.domain.TbItemEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author knox
 * @date 2020-12-20
 */
public interface ItemRepository extends ElasticsearchRepository<TbItemEntity, String> {

}
