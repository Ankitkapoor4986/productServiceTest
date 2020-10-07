package com.ankit.product.controller;

import com.ankit.product.exception.ValuesNotValidException;
import com.ankit.product.model.Product;
import com.ankit.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Mono<Long> addProduct(@RequestBody Product product) throws ValuesNotValidException {
        return productService.addProduct(product);
    }

    @GetMapping("/findProduct/{id}")
    public Mono<Product> findProduct(@PathVariable long id) {
        return productService.findProduct(id);
    }

    @RequestMapping(method=RequestMethod.DELETE,path = "/deleteProduct")
    public Mono<Boolean> deleteProduct(long id) {
        return productService.deleteProduct(id);
    }

    @PutMapping(path = "/updateProduct")
    public Mono<Boolean> updateProduct(Product product) {
        return productService.updateProduct(product);
    }
}
