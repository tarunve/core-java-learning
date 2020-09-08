package com.realworld.example.business.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realworld.example.business.api.ClientBO;
import com.realworld.example.data.api.ClientDO;
import com.realworld.example.data.api.ProductDO;
import com.realworld.example.model.api.Amount;
import com.realworld.example.model.api.Client;
import com.realworld.example.model.api.Currency;
import com.realworld.example.model.api.Product;
import com.realworld.example.model.impl.AmountImpl;

/**
 * Data Object for the Client entity.
 */
@Service
public class ClientBOImpl implements ClientBO {

	@Autowired
	ProductDO productDO;

	@Autowired
	ClientDO clientDO;

	public Amount getClientProductsSum(long clientId) {
		List<Product> existingProducts = productDO.getAllProducts(clientId);
		return new AmountImpl(calculateClientProductSum(existingProducts), Currency.EURO);
	}

	public void saveChangedProducts(long clientId, List<Product> userEnteredProducts) {
		List<Product> databaseProducts = productDO.getAllProducts(clientId);
		updateExistingProductsWhichAreModified(clientId, userEnteredProducts, databaseProducts);
		insertNewProducts(clientId, userEnteredProducts, databaseProducts);
		deleteStaleProducts(clientId, databaseProducts, userEnteredProducts);
	}

	public void calculateAndSaveClientProductSum(Client client) {
		BigDecimal clientProductSum = calculateClientProductSum(client.getProducts());
		client.setProductAmount(clientProductSum);
		clientDO.saveClient(client);
	}

	private void deleteStaleProducts(long clientId, List<Product> existingProducts, List<Product> newProducts) {
		Map<Long, Product> newProductsMap = convertToMap(newProducts);
		for (Product product1 : existingProducts) {
			if (!newProductsMap.containsKey(product1.getId())) {
				productDO.deleteProduct(clientId, product1);
			}
		}
	}

	private void insertNewProducts(long clientId, List<Product> newProducts, List<Product> existingProducts) {
		Map<Long, Product> existingProductsMap = convertToMap(existingProducts);
		for (Product newProduct : newProducts) {
			if (!existingProductsMap.containsKey(newProduct.getId())) {
				productDO.insertProduct(clientId, newProduct);
			}
		}
	}

	private void updateExistingProductsWhichAreModified(long clientId, List<Product> newProducts,
			List<Product> existingProducts) {
		Map<Long, Product> existingProductsMap = convertToMap(existingProducts);
		for (Product newProduct : newProducts) {
			if (existingProductsMap.containsKey(newProduct.getId())) {
				productDO.updateProduct(clientId, newProduct);
			}
		}
	}

	private Map<Long, Product> convertToMap(List<Product> products) {
		Map<Long, Product> productMap = new HashMap<Long, Product>();
		for (Product existingProduct : products) {
			productMap.put(existingProduct.getId(), existingProduct);
		}
		return productMap;
	}

	private BigDecimal calculateClientProductSum(List<Product> existingProducts) {
		BigDecimal clientProductsSum = BigDecimal.ZERO;

		for (Product product : existingProducts) {
			clientProductsSum = clientProductsSum.add(product.getAmount().getValue());
		}
		return clientProductsSum;
	}

}