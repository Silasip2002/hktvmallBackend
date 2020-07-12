package com.hktv.productAPI.controller;

import com.hktv.productAPI.exception.ProductNotFoundException;
import com.hktv.productAPI.model.Product;
import com.hktv.productAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProdcuts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{code}")
    public Product getProdcutByID(@PathVariable String  code) throws ProductNotFoundException {
        Optional<Product> optProduct = productRepository.findById(code);
        if(optProduct.isPresent()) {
            return optProduct.get();
        }else {
            throw new ProductNotFoundException("Product not found with code " + code);
        }
    }

    @PostMapping("/product")
    public Product createProdcut(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/products/{code}")
    public Product updateProdcut(@PathVariable String code,
                                 @Valid @RequestBody Product newProductInfo) throws ProductNotFoundException {
        return productRepository.findById(code)
                .map(product -> {
                    product.setCode(newProductInfo.getCode());
                    product.setName(newProductInfo.getName());
                    product.setWeight(newProductInfo.getWeight());
                    return productRepository.save(product);
                }).orElseThrow(() -> new ProductNotFoundException("Product not found with code " + code));
    }

    @DeleteMapping("/products/{code}")
    public String deleteProdcut(@PathVariable String code) throws ProductNotFoundException {
        return productRepository.findById(code)
                .map(product -> {
                    productRepository.delete(product);
                    return "Delete Successfully!";
                }).orElseThrow(() -> new ProductNotFoundException("Product not found with code " + code));
    }
}

