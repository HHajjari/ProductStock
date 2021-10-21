package com.xyz.productStock.dto;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * The class is for wrapping all fields related to ProductCreateDto
 * @version 1.0
 * @author Hossein Hajjari
 */

@Data
@Accessors(chain = true)
public class ProductCreateDto {

    private String title;
    private Float price;

}
