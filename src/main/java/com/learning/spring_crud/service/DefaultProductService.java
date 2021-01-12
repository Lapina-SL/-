package com.learning.spring_crud.service;

import com.learning.spring_crud.entity.Product;
import com.learning.spring_crud.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

import java.util.List;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository repository;

    @Override
    public Product saveProduct(Product product) throws ValidationException {
        validateProductData(product);
        repository.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Integer id) {
        repository.deleteById(id);
    }


    @Override
    public Product findByName(String name) {
        Product product = repository.findByName(name);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void updateProduct(String description, Integer id) {
       Product product = repository.getOne(id);
       product.setDescription(description);
       repository.save(product);
    }

    private void validateProductData(Product product) throws ValidationException {
        if (isNull(product)) {
            throw new ValidationException("Object product is null");
        }
        if (isNull(product.getName()) || product.getName().isEmpty()) {
            throw new ValidationException("Name is empty");
        }
    }
}
