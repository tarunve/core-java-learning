package com.realworld.example.data.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.realworld.example.data.api.ProductDO;
import com.realworld.example.model.api.Currency;
import com.realworld.example.model.api.Product;
import com.realworld.example.model.api.ProductType;
import com.realworld.example.model.impl.AmountImpl;
import com.realworld.example.model.impl.ProductImpl;

public class ProductDODummyImpl implements ProductDO {

	public List<Product> getAllProducts(long clientId) {
		List<Product> products = Arrays.asList(createProductWithAmount("5.0"), createProductWithAmount("6.0"));
		return products;
	}

	private Product createProductWithAmount(String amount) {
		return new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE, new AmountImpl(new BigDecimal(amount), Currency.EURO));
	}

	public List<Product> insertProduct(long clientId, Product product) {
		return null;
	}

	public List<Product> deleteProduct(long clientId, Product product) {
		return null;
	}

	public List<Product> updateProduct(long clientId, Product product) {
		return null;
	}

}
