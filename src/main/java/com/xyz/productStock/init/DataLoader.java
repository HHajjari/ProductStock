package com.xyz.productStock.init;

import com.xyz.productStock.model.Product;
import com.xyz.productStock.model.ProductStock;
import com.xyz.productStock.repository.ProductRepository;
import com.xyz.productStock.repository.ProductStockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Deprectated
 * This class was used for testing purposes
 */
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductStockRepository productStockRepository;

    public void run(ApplicationArguments args) {

        Product p2 = new Product().setTitle("Iphone2").setPrice(99.5f);
        ProductStock ps2 = new ProductStock().setProduct(p2).setAvailaleCount(100);
        productStockRepository.save(ps2);

        Product p3 = productRepository.getProductById(p2.getId());

    }
}