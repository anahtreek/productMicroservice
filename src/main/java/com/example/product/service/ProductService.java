package com.example.product.service;


import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    Logger logger = LoggerFactory.getLogger("ProductRepository");

    public Product addProduct(Product product){
        Product p = repository.save(product);
        logger.info(" added new product:"+p.getId());
        return p;
    }

    public List<Product> getProductsByName(String productName){
        return repository.findByProductName(productName);
    }
    public List<Product> getProductsByService(String service){
        return repository.findByServiceId(service);
    }

    public Iterable<Product> getAllProducts(){
        return  repository.findAll();
    }

    public Long deleteProduct(long id){
        Optional<Product>  product = repository.findById(id);
        if (product.isPresent())
        {
        repository.delete(product.get());
        return  id;}
        else{
            return -1L;
        }
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);

    }


}