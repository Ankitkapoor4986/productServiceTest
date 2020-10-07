package com.ankit.product.service.impl;

import com.ankit.product.dao.ProductDao;
import com.ankit.product.exception.ValuesNotValidException;
import com.ankit.product.model.KeyAttributes;
import com.ankit.product.model.Product;
import com.ankit.product.service.ProductService;
import com.ankit.product.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDao productDao;

    @Autowired
    private Validator validator;

    @Override
    public Mono<Long> addProduct(Product product) throws ValuesNotValidException {
        validateProductKeys(product);
        return Mono.just(productDao.addProduct(product));
    }

    private void validateProductKeys(Product product) throws ValuesNotValidException {
        Set<String> keys = product.getKeyAttributes().stream().filter(keyAttribute ->
                !validator.validate(keyAttribute))
                .map(KeyAttributes::getKey)
                .collect(Collectors.toSet());
        if(!keys.isEmpty()){
            throw new ValuesNotValidException(keys);
        }
    }

    @Override
    public Mono<Product> findProduct(long id) {
        return Mono.just(productDao.findProduct(id))
                ;
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
