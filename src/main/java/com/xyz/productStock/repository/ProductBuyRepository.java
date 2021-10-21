package com.xyz.productStock.repository;

import com.xyz.productStock.model.ProductBuy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * The class acts as dao for product buy entity
 * @version 1.0
 * @author Hossein Hajjari
 */

@Repository
public interface ProductBuyRepository extends CrudRepository<ProductBuy, Long> { }
