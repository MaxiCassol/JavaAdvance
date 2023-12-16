package com.ApiRESTful.ApiRESTfulProductos.service.impl;

import com.ApiRESTful.ApiRESTfulProductos.model.Product;
import com.ApiRESTful.ApiRESTfulProductos.repository.ProductRepository;
import com.ApiRESTful.ApiRESTfulProductos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
