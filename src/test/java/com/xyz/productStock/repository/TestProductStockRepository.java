package com.xyz.productStock.repository;

import com.xyz.productStock.model.Product;
import com.xyz.productStock.model.ProductStock;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestProductStockRepository {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductStockRepository productStockRepository;

    @Test
    void testSaveProductStock() {

        Product product = new Product().setTitle("Iphone2").setPrice(99.5f);

        ProductStock productStock = new ProductStock().setProduct(product).setAvailaleCount(100);

        productStockRepository.save(productStock);

        assertTrue(productStock.getId() > 0);
    }

}
