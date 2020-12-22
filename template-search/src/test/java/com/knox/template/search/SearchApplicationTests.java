package com.knox.template.search;


import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SearchApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void contextLoads() {
    }

    // 增加索引
    @Test
    public void testIndex() {
        IndexRequest indexRequest = new IndexRequest("test");
        indexRequest.id("1");
        Map<String, Object> map = new HashMap<>(16);
        map.put("id", "1111");
        map.put("content", "这是索引一");
        indexRequest.source(map);
        try {
            IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println(index.status());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getIndex() {
        SearchRequest searchRequest = new SearchRequest("test");
        try {
            SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            System.out.println("命中数：" + search.getHits().getTotalHits());
            System.out.println("符合条件的最大得分：" + search.getHits().getMaxScore());
            // 命中结果
            SearchHit[] hits = search.getHits().getHits();
            for (SearchHit hit : hits) {
                System.out.println(hit.getSourceAsMap());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
