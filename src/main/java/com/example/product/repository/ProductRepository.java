package com.example.product.repository;

import com.example.product.entity.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByProductName(String productName);
    List<Product> findByServiceId(String serviceId);




}
