package com.knox.template.search.controller;

import com.knox.template.commons.domain.TbItemEntity;
import com.knox.template.commons.mapper.TbBrandMapper;
import com.knox.template.commons.mapper.TbItemMapper;
import com.knox.template.search.BrandRepository;
import com.knox.template.search.ItemRepository;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.join.query.JoinQueryBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.util.ObjectUtils;

import java.util.List;

@SpringBootTest
class TbItemControllerTest {


    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    void searchByTitle() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        // 关键词
        String keyword = "";
        if (ObjectUtils.isEmpty(keyword)) {
            builder.withQuery(QueryBuilders.matchAllQuery());
        } else {
            builder.withQuery(QueryBuilders.multiMatchQuery(keyword, "title"));
        }


        // 查询参数
        QueryBuilder queryBuilder = JoinQueryBuilders.hasChildQuery("item",
                QueryBuilders.matchQuery("title", "小米"), ScoreMode.Max);
        Pageable pageable = PageRequest.of(1, 10);

        builder.withQuery(queryBuilder).withPageable(pageable);

        NativeSearchQuery build = builder.build();

        SearchHits<TbItemEntity> searchHits = elasticsearchRestTemplate.search(build, TbItemEntity.class);

        List<SearchHit<TbItemEntity>> searchHits1 = searchHits.getSearchHits();
        for (SearchHit<TbItemEntity> tbItemEntitySearchHit : searchHits1) {
            System.out.println(tbItemEntitySearchHit.toString());
        }

    }
}