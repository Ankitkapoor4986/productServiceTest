package com.ankit.product.dao;

import com.ankit.product.model.Product;

public interface ProductDao {

    long addProduct(Product product);
    Product findProduct(long id);
    boolean deleteProduct(long id);
    boolean updateProduct(Product product);
}
