package com.expert.produtccatalog.repository;

import com.expert.produtccatalog.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author https://github.com/alisonrodolfo
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    /* Created by Alison on 19/02/2022 */
}
