package com.hktv.productAPI.exception;

public class ProductNotFoundException extends Exception{
    private String code;

    public ProductNotFoundException(String code){
        super(String.format("Product is not found with code : '%s'", code));
    }
}
