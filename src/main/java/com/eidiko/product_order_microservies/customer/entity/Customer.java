package com.eidiko.product_order_microservies.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customerTable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private int id;

    private String name ;

}
