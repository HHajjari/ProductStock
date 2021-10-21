package com.xyz.productStock.controller.v1.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * The class is for wrapping all fields required for stock increase command
 * @version 1.0
 * @author Hossein Hajjari
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ProductStockRefillRequest {

    @NotNull(message = "The parameter [id] should not be null")
    @Positive(message = "The parameter [id] should be pisitive")
    private Long id;

    @NotNull(message = "The parameter [valueToAdded] should not be null")
    @Positive(message = "The parameter [valueToAdded] should be pisitive")
    private Integer valueToAdded;
}

