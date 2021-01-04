package com.tiny.service.search.repository;

import com.tiny.commons.domain.TbBrandEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author knox
 * @date 2020-12-20
 */
public interface BrandRepository extends ElasticsearchRepository<TbBrandEntity, Integer> {

}
