package com.xyz.productStock.controller.v1;

import com.xyz.productStock.controller.v1.request.ProductBuyRequest;
import com.xyz.productStock.controller.v1.request.ProductStockRefillRequest;
import com.xyz.productStock.dto.ProductBuyDto;
import com.xyz.productStock.dto.ProductRefillStockDto;


/**
 * The class is for mapping request commands to dto objects
 * @version 1.0
 * @author Hossein Hajjari
 */

public class Mapper {

    public static ProductBuyDto toProductBuyDto(ProductBuyRequest productBuyRequest)
    {
        return new ProductBuyDto()
                .setProductId(productBuyRequest.getId())
                .setCustomerEmail(productBuyRequest.getCustomerEmail())
                .setItemCount(productBuyRequest.getItemCount());
    }

    public static ProductRefillStockDto toProductRefillStockDto(ProductStockRefillRequest productStockRefillRequest)
    {
        return new ProductRefillStockDto()
                .setProductId(productStockRefillRequest.getId())
                .setValue(productStockRefillRequest.getValueToAdded());
    }
}
