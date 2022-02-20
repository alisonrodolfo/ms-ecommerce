package com.expert.produtccatalog.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author https://github.com/alisonrodolfo
 */
@Getter
@Setter
@Document(indexName = "product", indexStoreType = "catalog")
public class Product {
    /* Created by Alison on 19/02/2022 */
    @Id
    private Long id;
    private String name;
    private int amount;
}
