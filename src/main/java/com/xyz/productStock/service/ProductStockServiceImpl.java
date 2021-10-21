package com.xyz.productStock.service;

import com.xyz.productStock.dto.Mapper;
import com.xyz.productStock.dto.ProductStockDto;
import com.xyz.productStock.dto.ProductRefillStockDto;
import com.xyz.productStock.exception.EntityNotFoundException;
import com.xyz.productStock.exception.EntityType;
import com.xyz.productStock.model.Product;
import com.xyz.productStock.model.ProductStock;
import com.xyz.productStock.repository.ProductRepository;
import com.xyz.productStock.repository.ProductStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * The class implements ProductStockService interface
 * @version 1.0
 * @author Hossein Hajjari
 */

@Service
public class ProductStockServiceImpl implements ProductStockService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductStockRepository productStockRepository;

    @Override
    public ProductStockDto getProductStockByProductId(Long id)
    {
        ProductStock productStock = productStockRepository.getProductStockByProductId(id);

        if(productStock == null)
        {
            throw new EntityNotFoundException(EntityType.ProductStock, String.format("Stock not available for productId[%s]", id));
        }

        return Mapper.toProductStockDto(productStock);
    }

    @Override
    @Transactional
    public ProductRefillStockDto refillProductStock(ProductRefillStockDto refillProductStockDto)
    {
        Long productId = refillProductStockDto.getProductId();

        Product product = productRepository.getProductById(productId);

        if(product == null)
        {
            throw new EntityNotFoundException(EntityType.Product, String.format("Refill product stock failed due to product[%s] is not found.", productId));
        }

        ProductStock productStock = product.getStock();

        if(productStock == null)
        {
            throw new EntityNotFoundException(EntityType.ProductStock, String.format("Refill product stock failed due to product[%s] has not product stock.", productId));
        }

        Integer newAvailableValue = productStock.getAvailaleCount() + refillProductStockDto.getValue();

        productStock.setAvailaleCount(newAvailableValue);

        productStockRepository.save(productStock);

        return refillProductStockDto;
    }
}
