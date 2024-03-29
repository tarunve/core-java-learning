package com.realworld.example.data.api;

import java.util.List;

import com.realworld.example.model.api.Product;

/**
 * Data Object for the Client entity.
 */
public interface ProductDO {

    /**
     * Retrieve products for the client.
     * 
     * @param clientId client id.
     */
    List<Product> getAllProducts(long clientId);
    
    /**
     * Insert new product for the client.
     * 
     * @param clientId client id.
     * @param product product to be inserted.
     */
    List<Product> insertProduct(long clientId, Product product);

    /**
     * Delete product for the client.
     * 
     * @param clientId client id.
     * @param product product to be deleted.
     */
    List<Product> deleteProduct(long clientId, Product product);

    /**
     * Update product for the client.
     * 
     * @param clientId client id.
     * @param product product to be updated.
     */
    List<Product> updateProduct(long clientId, Product product);
}
