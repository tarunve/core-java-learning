package com.realworld.example.model.api;

/**
 * Product Model API.
 */
public interface Product {

	long getId();
	
    String getName();

    ProductType getType();
    
    Amount getAmount();
}
