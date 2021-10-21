package com.xyz.productStock.controller.v1.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;


/**
 * The class is for wrapping all fields required for handling buy command
 * @version 1.0
 * @author Hossein Hajjari
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ProductBuyRequest {

    @NotNull(message = "The parameter [id] should not be null")
    @Positive(message = "The parameter [id] should be pisitive")
    private Long id;

    @NotNull(message = "The parameter [itemCount] should not be null")
    @Positive(message = "The parameter [itemCount] should be pisitive")
    private Integer itemCount;

    @NotNull(message = "The parameter [coustomerEmail] should not be null")
    @Pattern(regexp=".+@.+\\..+", message="The parameter [customerEmail] is not a valid email address")
    private String customerEmail;
}

