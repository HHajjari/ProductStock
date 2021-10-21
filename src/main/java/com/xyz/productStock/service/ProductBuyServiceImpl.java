package com.xyz.productStock.service;

import com.xyz.productStock.dto.Mapper;
import com.xyz.productStock.dto.ProductBuyDto;
import com.xyz.productStock.exception.BusinessException;
import com.xyz.productStock.exception.BusinessRule;
import com.xyz.productStock.exception.EntityNotFoundException;
import com.xyz.productStock.exception.EntityType;
import com.xyz.productStock.model.Product;
import com.xyz.productStock.model.ProductBuy;
import com.xyz.productStock.model.ProductStock;
import com.xyz.productStock.repository.ProductBuyRepository;
import com.xyz.productStock.repository.ProductRepository;
import com.xyz.productStock.repository.ProductStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;


/**
 * The class implements ProductBuyService
 * @version 1.0
 * @author Hossein Hajjari
 */
@Service
public class ProductBuyServiceImpl implements ProductBuyService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductStockRepository productStockRepository;

    @Autowired
    ProductBuyRepository productBuyRepository;

    @Transactional
    public ProductBuyDto buy(ProductBuyDto productBuyDto)
    {
        Long productId = productBuyDto.getProductId();

        Product product = productRepository.getProductById(productId);

        if(product == null)
        {
            throw new EntityNotFoundException(EntityType.Product, String.format("Buy product failed due to product[%s] is not found.", productId));
        }

        ProductStock productStock = product.getStock();

        if(productStock == null)
        {
            throw new EntityNotFoundException(EntityType.ProductStock, String.format("Buy product failed due to product[%s] has not a valid stock.", productId));
        }

        if(productStock.getAvailaleCount() < productBuyDto.getItemCount())
        {
            throw new BusinessException(BusinessRule.ItemCountIsHigherThanSotckCount, String.format("Buy product failed due to product[%s] has not enough stock.", productId));
        }

        ProductBuy productBuy = Mapper.toProductBuy(productBuyDto);

        productBuy.setInsertDate(new Date())
                .setItemPrice(product.getPrice())
                .setProduct(product);

        productBuyRepository.save(productBuy);

        Integer currentCount = productStock.getAvailaleCount();

        productStock.setAvailaleCount(currentCount - productBuy.getItemCount());

        productStockRepository.save(productStock);

        productBuyDto.setTraceCode(productBuy.getId());

        return productBuyDto;
    }
}
