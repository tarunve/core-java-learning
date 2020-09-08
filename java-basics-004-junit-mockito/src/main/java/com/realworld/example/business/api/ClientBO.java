package com.realworld.example.business.api;

import java.util.List;

import com.realworld.example.model.api.Amount;
import com.realworld.example.model.api.Client;
import com.realworld.example.model.api.Product;

/**
 * Business Interface for Client.
 */
public interface ClientBO {

    /**
     * Sum of product amounts. Assumes Currency as EURO.
     * @param clientId clientId
     * @return the sum amount
     */
    Amount getClientProductsSum(long clientId);

    /**
     * Compares the new products with existing products and saves changed
     * products.
     * @param clientId clientId
     * @param newProducts
     */
    void saveChangedProducts(long clientId, List<Product> newProducts);

    /**
     * Calculates client product sum and saves it to database.
     * @param client
     */
    void calculateAndSaveClientProductSum(Client client);

}