package com.expert.produtccatalog.config;


import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


/**
 * The type Elastic search config.
 *
 * @author https ://github.com/alisonrodolfo
 */
@Configuration
@EnableElasticsearchRepositories(basePackages="com.expert.produtccatalog.repository")
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    /**
     * Elasticsearch client rest high level client.
     *
     * @return the rest high level client
     */
    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200", "localhost:9300")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}