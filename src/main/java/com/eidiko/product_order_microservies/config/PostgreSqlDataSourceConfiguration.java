package com.eidiko.product_order_microservies.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration

@EnableJpaRepositories(
        entityManagerFactoryRef = "postgreSqlEntityManagerFactoryBean"
        ,basePackages = "com.eidiko.product_order_microservies.student.repository"
        ,transactionManagerRef = "postgreSqlTransactionManager"
)
public class PostgreSqlDataSourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.postgre")
    public DataSourceProperties postgreSqlDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean

    public DataSource postgreSqlDataSource (){

        return postgreSqlDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }
}
