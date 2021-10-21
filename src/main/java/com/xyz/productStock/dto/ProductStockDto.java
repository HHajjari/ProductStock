package com.xyz.productStock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The class is for wrapping all fields related to ProductStockDto
 * @version 1.0
 * @author Hossein Hajjari
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockDto {
    private Integer available;
}
