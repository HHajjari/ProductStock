package com.xyz.productStock.repository;

import com.xyz.productStock.model.ProductStock;
import org.springframework.data.repository.CrudRepository;


/**
 * The class acts as dao for product stock entity
 * @version 1.0
 * @author Hossein Hajjari
 */

public interface ProductStockRepository extends CrudRepository<ProductStock, Long> {
    /**
     * loads product stock entity from database
     * @param productId represtents given product identifier
     * @return product stock information
     */
    ProductStock getProductStockByProductId(Long productId);
}
