package com.ankit.product.dao.impl;

import com.ankit.product.dao.ProductDao;
import com.ankit.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductArrayListDao implements ProductDao {

    public static final String PRODUCT_NOT_FOUND = "Product not found";
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
                .findFirst().orElse(new Product(PRODUCT_NOT_FOUND, PRODUCT_NOT_FOUND));
    }

    @Override
    public boolean deleteProduct(long id) {
        return products.removeIf(product -> product.getId() == id);
    }

    @Override
    public boolean updateProduct(Product product) {
        Product productInDb = findProduct(product.getId());
        if(productInDb.getName().equals(PRODUCT_NOT_FOUND)){
            return false;
        }
        productInDb.setDescription(product.getDescription());
        productInDb.setKeyAttributes(product.getKeyAttributes());
        productInDb.setName(product.getName());
        productInDb.setPrice(product.getPrice());
        productInDb.setReviews(product.getReviews());
        return true;
    }
}
