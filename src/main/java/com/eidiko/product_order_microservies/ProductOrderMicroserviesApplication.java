package com.eidiko.product_order_microservies;

import com.eidiko.product_order_microservies.customer.entity.Customer;
import com.eidiko.product_order_microservies.customer.repository.CustomerDAO;
import com.eidiko.product_order_microservies.product.entity.Product;
import com.eidiko.product_order_microservies.product.repository.ProductDAO;
import com.eidiko.product_order_microservies.student.entity.Student;
import com.eidiko.product_order_microservies.student.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductOrderMicroserviesApplication implements CommandLineRunner {

	@Autowired
	private ProductDAO productDAO ;
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private Student student ;

	public static void main(String[] args) {
		SpringApplication.run(ProductOrderMicroserviesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(student);

		Product product = new Product(2 ,"Bottle" ,80.0);

		productDAO.save(product);
		Customer customer = new Customer(101 ,"adil");
		customerDAO.save(customer);

		studentDAO.save(new Student(501 ,"sanketh" ,99.9));

	}
}
