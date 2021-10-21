package com.xyz.productStock.service;

import com.xyz.productStock.dto.ProductBuyDto;

import javax.transaction.Transactional;

/**
 * The interface represents defined services for buying a product
 * @version 1.0
 * @author Hossein Hajjari
 */
public interface ProductBuyService {

    /**
     * Handles buy process
     * @param productBuyDto contains customer's Email, product identifier, item count
     * @return information that proves buy is accepted including traceCode
     */
    @Transactional
    ProductBuyDto buy(ProductBuyDto productBuyDto);
}
