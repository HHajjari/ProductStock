package com.xyz.productStock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The class is for wrapping all fields related to ProductDto
 * @version 1.0
 * @author Hossein Hajjari
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private Float price;
    private int stock;
}
