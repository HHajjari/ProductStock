package com.xyz.productStock.service;

import com.xyz.productStock.dto.Mapper;
import com.xyz.productStock.dto.ProductCreateDto;
import com.xyz.productStock.dto.ProductDto;
import com.xyz.productStock.exception.DuplicateEntityException;
import com.xyz.productStock.model.Product;
import com.xyz.productStock.model.ProductStock;
import com.xyz.productStock.repository.ProductRepository;
import com.xyz.productStock.repository.ProductStockRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestProductService {

    @Autowired
    private ProductService productService;

    @Test
    void testProductSave_duplicateTitle_shouldThorwException() {
        assertThrows(DuplicateEntityException.class,
                () -> {
                    ProductCreateDto productDto = new ProductCreateDto().setTitle("Apple 11").setPrice(550f);
                    productService.addProduct(productDto);

                    ProductCreateDto productDtoDuplicate = new ProductCreateDto().setTitle("Apple 11").setPrice(150f);
                    productService.addProduct(productDtoDuplicate);
                });
    }

    @Test
    void testProductSave_validProduct_shouldBeSaved() {
        ProductCreateDto productDto = new ProductCreateDto().setTitle("Samsung A10").setPrice(550f);
        ProductDto productDtoInDb = productService.addProduct(productDto);
        assertTrue(productDtoInDb.getId() > 0);
    }
}
