package com.learning.spring_crud.service;

import com.learning.spring_crud.entity.Product;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface ProductService {
    Product saveProduct(Product product) throws ValidationException;

    void deleteProduct(Integer userId);


    Product findByName(String name);

    List<Product> findAll();


    void updateProduct(String description, Integer id);
}
