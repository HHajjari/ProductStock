package com.xyz.productStock.service;

import com.xyz.productStock.dto.*;
import com.xyz.productStock.exception.BusinessException;
import com.xyz.productStock.exception.DuplicateEntityException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestProductBuyService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductBuyService productBuyService;

    @Test
    void test_buy() {

        ProductCreateDto productDto = new ProductCreateDto().setTitle("Samsung A8").setPrice(550f);
        ProductDto productDtoInDb = productService.addProduct(productDto);

        ProductBuyDto productBuyDto1 = new ProductBuyDto().setProductId(productDtoInDb.getId()).setItemCount(10).setCustomerEmail("hajjari@gmail.com");
        productBuyService.buy(productBuyDto1);
        assertTrue(productBuyService.buy(productBuyDto1).getTraceCode() > 0);

        assertThrows(BusinessException.class,
                () -> {
                    ProductBuyDto productBuyDto2 = new ProductBuyDto().setProductId(productDtoInDb.getId()).setItemCount(91).setCustomerEmail("hajjari@gmail.com");
                    productBuyService.buy(productBuyDto2);
                });

    }
}
