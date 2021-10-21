package com.xyz.productStock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * The class is for wrapping all fields related to ProductBuyDto
 * @version 1.0
 * @author Hossein Hajjari
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductBuyDto {
    private Long traceCode;
    private String customerEmail;
    private Long productId;
    private Integer itemCount;
}
