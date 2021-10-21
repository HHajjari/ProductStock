package com.xyz.productStock.service;

import com.xyz.productStock.dto.ProductRefillStockDto;
import com.xyz.productStock.dto.ProductStockDto;

import javax.transaction.Transactional;

/**
 * The interface represents defined services for stock
 * @version 1.0
 * @author Hossein Hajjari
 */

public interface ProductStockService {
    /**
     * Reads current stock of give product
     * @param id represents product identifier
     * @return stock information
     */
    ProductStockDto getProductStockByProductId(Long id);

    /**
     * Increases the stock for given product
     * @param refillProductStockDto represents product id and desired value that to be added to current stock
     * @return informatoin that shows refillment is done
     */
    @Transactional
    ProductRefillStockDto refillProductStock(ProductRefillStockDto refillProductStockDto);
}
