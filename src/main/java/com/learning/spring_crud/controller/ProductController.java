package com.learning.spring_crud.controller;

import com.learning.spring_crud.entity.Product;
import com.learning.spring_crud.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Log
public class ProductController {

    private final ProductService service;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) throws ValidationException {
        log.info("Handling save products: " + product);
        return service.saveProduct(product);
    }

    @PostMapping("/update/{id}")
    public void saveProduct(@PathVariable Integer id, @RequestParam String description) {
        log.info("Handling update product: " + id);
        service.updateProduct(description, id);
    }

    @GetMapping("/findAll")
    public List<Product> findAll() {
        log.info("Handling find all products request");
        return service.findAll();
    }

    @GetMapping("/findByName")
    public Product findByName(@RequestParam String name) {
        log.info("Handling find by name request: " + name);
        return service.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        log.info("Handling delete product request: " + id);
        service.deleteProduct(id);
    }
}
