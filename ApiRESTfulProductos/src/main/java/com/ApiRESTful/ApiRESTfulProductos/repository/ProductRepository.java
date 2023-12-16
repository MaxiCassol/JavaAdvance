package com.ApiRESTful.ApiRESTfulProductos.repository;

import com.ApiRESTful.ApiRESTfulProductos.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository extends JpaRepository<Product, Long> {

    private final List<Product> products = new ArrayList<>();

    public Product save(Product product) {
        product.setId((long) (products.size() + 1));
        products.add(product);
        return product;
    }

    public List<Product> findAll() {
        return products;
    }
}
