package com.eidiko.product_order_microservies.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration

public class PostgreJpaConfiguration {

@Bean
    public LocalContainerEntityManagerFactoryBean postgreSqlEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
                                                                                     @Qualifier("postgreSqlDataSource") DataSource dataSource){
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.eidiko.product_order_microservies.student.entity")
                .build();
    }

    @Bean
    public PlatformTransactionManager postgreSqlTransactionManager(@Qualifier("postgreSqlEntityManagerFactoryBean")
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){

        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }
}
