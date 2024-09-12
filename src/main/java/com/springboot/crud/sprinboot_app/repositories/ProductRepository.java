package com.springboot.crud.sprinboot_app.repositories;

import com.springboot.crud.sprinboot_app.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    boolean existsBySku(String sku);
}
