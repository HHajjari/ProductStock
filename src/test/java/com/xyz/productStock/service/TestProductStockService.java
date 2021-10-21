package com.xyz.productStock.service;

import com.xyz.productStock.dto.ProductCreateDto;
import com.xyz.productStock.dto.ProductDto;
import com.xyz.productStock.dto.ProductRefillStockDto;
import com.xyz.productStock.dto.ProductStockDto;
import com.xyz.productStock.exception.DuplicateEntityException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestProductStockService {

    @Autowired
    private ProductStockService productSockService;

    @Autowired
    private ProductService productService;

    @Test
    void test_getProductStockByProductId() {
        ProductCreateDto productDto = new ProductCreateDto().setTitle("Samsung S1").setPrice(550f);
        ProductDto productDtoInDb = productService.addProduct(productDto);
        assertTrue(productSockService.getProductStockByProductId(productDtoInDb.getId()).getAvailable() == 100);
    }


    @Test
    void test_refillProductStock() {
        ProductCreateDto productDto = new ProductCreateDto().setTitle("Samsung S8").setPrice(550f);
        ProductDto productDtoInDb = productService.addProduct(productDto);
        ProductRefillStockDto refillStockDto = new ProductRefillStockDto().setProductId(productDtoInDb.getId()).setValue(10);
        productSockService.refillProductStock(refillStockDto);
        ProductStockDto productStockDto = productSockService.getProductStockByProductId(productDtoInDb.getId());
        assertTrue(productStockDto.getAvailable() == 110);
    }
}
