package com.eidiko.product_order_microservies.customer.repository;

import com.eidiko.product_order_microservies.customer.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer,Integer> {
}
