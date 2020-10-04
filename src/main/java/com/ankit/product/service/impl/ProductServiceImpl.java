package com.ankit.product.service.impl;

import com.ankit.product.dao.ProductDao;
import com.ankit.product.model.Product;
import com.ankit.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDao productDao;

    @Override
    public Mono<Long> addProduct(Product product) {
        return Mono.just(productDao.addProduct(product));
    }

    @Override
    public Mono<Product> findProduct(long id) {
        return Mono.just(productDao.findProduct(id));
    }

    @Override
    public Mono<Boolean> deleteProduct(long id) {
        return Mono.just(productDao.deleteProduct(id));
    }

    @Override
    public Mono<Boolean> updateProduct(Product product) {
        return Mono.just(productDao.updateProduct(product));
    }
}
