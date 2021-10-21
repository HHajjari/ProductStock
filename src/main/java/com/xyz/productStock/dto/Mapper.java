package com.xyz.productStock.dto;

import com.xyz.productStock.model.Product;
import com.xyz.productStock.model.ProductBuy;
import com.xyz.productStock.model.ProductStock;


/**
 * The class is for mapping dto objects to domain models
 * @version 1.0
 * @author Hossein Hajjari
 */

public class Mapper {
    public static ProductBuy toProductBuy(ProductBuyDto productBuyDto)
    {
        return new ProductBuy()

                .setCustomerEmail(productBuyDto.getCustomerEmail())
                .setItemCount(productBuyDto.getItemCount());
    }
    public static ProductDto toProductDto(Product product)
    {
        return new ProductDto()
                .setId(product.getId())
                .setTitle(product.getTitle())
                .setPrice(product.getPrice())
                .setStock(product.getStock().getAvailaleCount());
    }

    public static Product toProduct(ProductCreateDto productCreateDto)
    {
        return new Product()
                .setTitle(productCreateDto.getTitle())
                .setPrice(productCreateDto.getPrice());
    }

    public static ProductStockDto toProductStockDto(ProductStock productStock)
    {
        return new ProductStockDto()
                .setAvailable(productStock.getAvailaleCount());
    }
}
