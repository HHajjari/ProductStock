package com.xyz.productStock.service;

import com.xyz.productStock.dto.Mapper;
import com.xyz.productStock.dto.ProductCreateDto;
import com.xyz.productStock.dto.ProductDto;
import com.xyz.productStock.exception.*;

import com.xyz.productStock.model.Product;
import com.xyz.productStock.model.ProductStock;
import com.xyz.productStock.repository.ProductRepository;
import com.xyz.productStock.repository.ProductStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The class implements ProductService interface
 * @version 1.0
 * @author Hossein Hajjari
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Value("${defaultAvailableCount}")
    private Integer defaultAvailableCount;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductStockRepository productStockRepository;

    @Override
    @Transactional
    public ProductDto addProduct(ProductCreateDto productCreateDto) {

        Product product = productRepository.getProductByTitle(productCreateDto.getTitle());

        if (product != null)
            throw new DuplicateEntityException(EntityType.Product, String.format("Product [%s] is already exists.", product.getTitle()));

        if (defaultAvailableCount < 0)
            throw new BusinessException(BusinessRule.DefaultProductAvailableCountIsNegative, String.format("The parameter [defaultAvailableCount] is negative."));

        Product productToSave = Mapper.toProduct(productCreateDto);

        ProductStock productStock = new ProductStock().setAvailaleCount(defaultAvailableCount);

        productToSave.setStock(productStock);

        productStock.setProduct(productToSave);

        productRepository.save(productToSave);

        return Mapper.toProductDto(productToSave);
    }

    @Override
    public ProductDto getProductById(Long id)
    {
        Product product = productRepository.getProductById(id);

        if (product == null) {
            throw new EntityNotFoundException(EntityType.Product, String.format("Product[%s] not found.", id));
        }

        return Mapper.toProductDto(product);
    }
}
