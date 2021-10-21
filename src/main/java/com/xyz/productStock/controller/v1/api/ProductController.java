package com.xyz.productStock.controller.v1.api;

import com.xyz.productStock.controller.Response;
import com.xyz.productStock.controller.v1.Mapper;
import com.xyz.productStock.controller.v1.request.ProductBuyRequest;
import com.xyz.productStock.controller.v1.request.ProductGetByIdRequest;
import com.xyz.productStock.controller.v1.request.ProductStockRefillRequest;
import com.xyz.productStock.dto.ProductCreateDto;
import com.xyz.productStock.dto.ProductDto;
import com.xyz.productStock.service.ProductBuyService;
import com.xyz.productStock.service.ProductService;
import com.xyz.productStock.service.ProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * The class is for handling incomming http requests regard to product stock.
 * @version 1.0
 * @author Hossein Hajjari
 */

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductStockService productStockService;

    @Autowired
    ProductBuyService productBuyService;

    /** Gets the product information
     * @param request contains product id
     * @return A json object containss product information
     */
    @GetMapping("/get")
    public Response getProductById(@Valid ProductGetByIdRequest request) {
        return Response.ok()
                .setPayload(productService.getProductById(request.getId()));
    }


    /** Gets the product stock
     * @param request contains product id
     * @return A json object contains product stock
     */
    @GetMapping("/stock")
    public Response getProductStockByProductId(@Valid ProductGetByIdRequest request) {
        return Response.ok()
                .setPayload(productStockService.getProductStockByProductId(request.getId()));
    }


    /** Refills product stock
     * @param request contains product id and refill value
     * @return A json object contains refill result
     */
    @GetMapping("/refill")
    public Response RefillProductStock(@Valid ProductStockRefillRequest request) {
        return Response.ok()
                .setPayload(productStockService.refillProductStock(Mapper.toProductRefillStockDto(request)));
    }


    /** Handles buy request
     * @param request contains product id, customer email and item count
     * @return A json object contains trace code
     */
    @GetMapping("/buy")
    public Response buyProduct(@Valid ProductBuyRequest request) {
        return Response.ok()
                .setPayload(productBuyService.buy(Mapper.toProductBuyDto(request)));
    }
}
