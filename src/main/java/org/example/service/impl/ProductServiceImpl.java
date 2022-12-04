package org.example.service.impl;

import lombok.AllArgsConstructor;
import org.example.dto.ProductBody;
import org.example.repository.ProductRepository;
import org.example.repository.entity.Product;
import org.example.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public UUID addProduct(ProductBody productBody) {
        return productRepository.save(new Product(productBody)).getId();
    }

    @Override
    public Product getProduct(UUID id) {
        return productRepository.findById(id).get();
    }

    @Override
    public UUID updateProduct(ProductBody modifyProductBody) {
        Product newProduct = new Product(modifyProductBody);
        newProduct.setId(modifyProductBody.getId());
        return productRepository.save(newProduct).getId();
    }

    @Override
    public void removeProduct(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
