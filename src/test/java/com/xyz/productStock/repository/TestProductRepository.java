package com.xyz.productStock.repository;

import com.xyz.productStock.model.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestProductRepository {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductStockRepository productStockRepository;


    @Test
    @Transactional
    void testProductSave() {
        Product product = new Product("Apple 12", 550f);
        productRepository.save(product);
        assertTrue(product.getId() > 0 );
    }

    @Test
    void testProductById() {
        Product product = new Product("Apple 12", 550f);
        productRepository.save(product);
        Product productById = productRepository.getProductById(product.getId());
        assertEquals(product.getId(), productById.getId());
    }

    @Test
    void testProductByTitle() {
        Product product = new Product("Apple 12", 550f);
        productRepository.save(product);
        Product productByTitle = productRepository.getProductByTitle(product.getTitle());
        assertEquals(product.getId(), productByTitle.getId());
    }
}
