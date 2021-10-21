package com.xyz.productStock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * The class is for wrapping all fields related to ProductRefillStockDto
 * @version 1.0
 * @author Hossein Hajjari
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ProductRefillStockDto {
    private Long productId;
    private Integer value;
}
