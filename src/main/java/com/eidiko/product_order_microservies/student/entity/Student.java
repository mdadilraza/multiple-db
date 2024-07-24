package com.eidiko.product_order_microservies.student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties("myapp.student")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_table")
public class Student {


    @Id
    private int id;

    private String name ;

    private double marks ;

}
