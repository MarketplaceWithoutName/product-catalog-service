package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.ProductBody;
import org.example.repository.entity.Product;
import org.example.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Slf4j
public class ProductController {

    ProductService productService;

    @PostMapping
    public ResponseEntity<UUID> addProduct(@RequestBody ProductBody productBody) {
        log.info("Request to add product with name {}", productBody.getName());
        return new ResponseEntity(productService.addProduct(productBody), HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable UUID productId) {
        log.info("Request to get product with id: {}", productId);
        return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity removeProduct(@PathVariable UUID productId) {
        log.info("Request to remove product with id: {}", productId);
        productService.removeProduct(productId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody ProductBody modifyProductBody) {
        log.info("Request to update product with id: {}", modifyProductBody);
        productService.updateProduct(modifyProductBody);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Product>> findAllProducts() {
        log.info("Request to find all products");
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
}
