package com.eidiko.product_order_microservies.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products-db")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {


    @Id
    private int id ;

    private String name ;

    private double price ;

}
