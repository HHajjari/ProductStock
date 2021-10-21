package com.xyz.productStock.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.util.Date;


/**
 * The class is for unified formatting all rest api respones or exceptions
 * @version 1.0
 * @author Hossein Hajjari
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Response<T> {

    private HttpStatus status;
    private T payload;
    private Object errors;

    public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.setStatus(HttpStatus.OK);
        return response;
    }

    public static <T> Response<T> validationException() {
        Response<T> response = new Response<>();
        response.setStatus(HttpStatus.BAD_REQUEST);
        return response;
    }

    public static <T> Response<T> exception() {
        Response<T> response = new Response<>();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }

    public static <T> Response<T> notFoundException() {
        Response<T> response = new Response<>();
        response.setStatus(HttpStatus.NOT_FOUND);
        return response;
    }

    public static <T> Response<T> duplicateException() {
        Response<T> response = new Response<>();
        response.setStatus(HttpStatus.CONFLICT);
        return response;
    }

    public static <T> Response<T> businessException() {
        Response<T> response = new Response<>();
        response.setStatus(HttpStatus.EXPECTATION_FAILED);
        return response;
    }

    public void addErrorMsgToResponse(String errorMsg, Exception ex) {
        ResponseError error = new ResponseError()
                .setMessage(ex.getMessage())
                .setTimestamp(new Date());
        setErrors(error);
    }
}

