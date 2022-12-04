package org.example.service;

import org.example.dto.ProductBody;
import org.example.repository.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    UUID addProduct(ProductBody productBody);
    Product getProduct(UUID id);
    UUID updateProduct(ProductBody modifyProductBody);
    void removeProduct(UUID id);
    List<Product> findAll();
}
