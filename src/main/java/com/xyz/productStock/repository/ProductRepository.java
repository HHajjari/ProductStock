package com.xyz.productStock.repository;

import com.xyz.productStock.model.Product;
import org.springframework.data.repository.CrudRepository;


/**
 * The class acts as dao for product entity
 * @version 1.0
 * @author Hossein Hajjari
 */

public interface ProductRepository extends CrudRepository<Product, Long> {
    /**
     * Loads product entity from database by identifier
     * @param id is product identifier
     * @return product entity
     */
    Product getProductById(Long id);

    /**
     * Loads product entity from database by title
     * @param title is prduct's title
     * @return product entity
     */
    Product getProductByTitle(String title);
}
