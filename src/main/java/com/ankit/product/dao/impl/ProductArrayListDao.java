package com.ankit.product.dao.impl;

import com.ankit.product.dao.ProductDao;
import com.ankit.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductArrayListDao implements ProductDao {

    private final List<Product> products = new ArrayList<>();
    private AtomicLong id = new AtomicLong(0);

    @Override
    public long addProduct(Product product) {
        product.setId(id.incrementAndGet());
         products.add(product);
         return id.get();

    }

    @Override
    public Product findProduct(long id) {
        return products.stream().filter(product -> id == product.getId())
                .findFirst().orElse(new Product());
    }

    @Override
    public boolean deleteProduct(long id) {
        return products.removeIf(product -> product.getId() == id);
    }

    @Override
    public boolean updateProduct(Product product) {
        boolean deleteProduct = deleteProduct(product.getId());
        if (deleteProduct) {
            addProduct(product);
        }
        return deleteProduct;
    }
}
