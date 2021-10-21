package com.xyz.productStock.service;

import com.xyz.productStock.dto.ProductCreateDto;
import com.xyz.productStock.dto.ProductDto;

import javax.transaction.Transactional;

/**
 * The interface represents defined services for product
 * @version 1.0
 * @author Hossein Hajjari
 */

public interface ProductService {

    /**
     * Handles adding a product to database
     * @param productCreateDto contains product name and price
     * @return information that proves product has been added to database including product identifier
     */
    @Transactional
    ProductDto addProduct(ProductCreateDto productCreateDto);


    /**
     * Loads a product's information from database
     * @param id represents product identifier
     * @return information of product
     */
    ProductDto getProductById(Long id);
}
