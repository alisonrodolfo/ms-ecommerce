package com.expert.produtccatalog.controller;
import com.expert.produtccatalog.model.Product;
import com.expert.produtccatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author https://github.com/alisonrodolfo
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    /* Created by Alison on 19/02/2022 */

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST)
    Product create(@RequestBody Product product) {

        return productRepository.save(product);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Optional<Product> findById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

}