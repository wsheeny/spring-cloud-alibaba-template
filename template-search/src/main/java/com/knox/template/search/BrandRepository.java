package com.knox.template.search;

import com.knox.template.commons.domain.TbBrandEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author knox
 * @date 2020-12-20
 */
public interface BrandRepository extends ElasticsearchRepository<TbBrandEntity, Integer> {

}
