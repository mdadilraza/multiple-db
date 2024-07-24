package com.eidiko.product_order_microservies.student.repository;

import com.eidiko.product_order_microservies.student.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDAO extends CrudRepository<Student , Integer> {
}
