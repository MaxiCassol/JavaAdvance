package com.ApiRESTful.ApiRESTfulProductos.service;

import com.ApiRESTful.ApiRESTfulProductos.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();
}
