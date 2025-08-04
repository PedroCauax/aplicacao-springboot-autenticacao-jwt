package com.springboot.Application.controllers;

import java.util.List;

import org.apache.naming.ContextAccessController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Application.models.Product;
import com.springboot.Application.services.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/product")
public class ProductController extends ContextAccessController{
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> listProducts(@RequestParam String param) {
        return productService.listProduct();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        Product product = productService.getForId(id);
        return ResponseEntity.ok(product);
    }
    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
