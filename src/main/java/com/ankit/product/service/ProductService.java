package com.ankit.product.service;

import com.ankit.product.exception.ValuesNotValidException;
import com.ankit.product.model.Product;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<Long> addProduct(Product product) throws ValuesNotValidException;
    Mono<Product> findProduct(long id);
    Mono<Boolean> deleteProduct(long id);
    Mono<Boolean> updateProduct(Product product);
}
