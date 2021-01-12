package com.learning.spring_crud.repository;

import com.learning.spring_crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);


//
//    @Modifying
//    @Query("update Product p set p.description = ?1 where p.id = ?2")
//    default void updateProduct(String description, Integer id) {
//
//    }
}
