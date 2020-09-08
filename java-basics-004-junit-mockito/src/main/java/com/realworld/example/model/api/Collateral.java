package com.realworld.example.model.api;

/**
 * Collateral Model API.
 */
public interface Collateral {
	
	long getId();
	
	String getName();

    CollateralType getType();
}
