package com.eidiko.product_order_microservies.product.repository;

import com.eidiko.product_order_microservies.product.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Integer> {
}
