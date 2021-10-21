package com.xyz.productStock.repository;

import com.xyz.productStock.model.Product;
import com.xyz.productStock.model.ProductBuy;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestProductBuyRepository {

    @Autowired
    private ProductBuyRepository productBuyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    void testSaveProductBuy() {

        Product product = new Product().setTitle("Iphone2").setPrice(99.5f);

        productRepository.save(product);

        ProductBuy productBuy = new ProductBuy().setProduct(product).setCustomerEmail("hajjari@gmail.com").setInsertDate(new Date()).setItemCount(3).setItemPrice(10.5f);

        productBuyRepository.save(productBuy);

        assertTrue(productBuy.getId() > 0);
    }

}
