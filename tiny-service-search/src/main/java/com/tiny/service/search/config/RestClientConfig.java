package com.tiny.service.search.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * 最新版已弃用yaml配置
 * <p>
 * # 最新版已启用，使用config
 * #spring.data.elasticsearch.cluster-name=my-application
 * #spring.data.elasticsearch.cluster-nodes=http://127.0.0.1:9300
 *
 * @author knox
 * @since 2020/12/2
 */
@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                // 使用RESTFul接口：9200
                // 弃用TransportClient接口：9300
                .connectedTo("localhost:9200")
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
