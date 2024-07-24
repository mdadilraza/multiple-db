package com.eidiko.product_order_microservies.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "mySqlEntityManagerFactoryBean",
        basePackages = "com.eidiko.product_order_microservies.product.repository",
        transactionManagerRef = "mySqlTransactionManager"
)
public class MySqlDataSourceConfiguration {

    @ConfigurationProperties("spring.datasource.mysql")

    @Bean
    public DataSourceProperties mySqlDataSourceProperties(){
        return new DataSourceProperties();
    }


//    @Primary
    @Bean
    public DataSource mySqlDataSource(){


        return mySqlDataSourceProperties().initializeDataSourceBuilder().build();
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setUrl(mySqlDataSourceProperties().getUrl());
//        dataSource.setUsername(mySqlDataSourceProperties().getUsername());
//        dataSource.setPassword(mySqlDataSourceProperties().getPassword());
//        dataSource.setDriverClassName(mySqlDataSourceProperties().getDriverClassName());
//   return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder){
        return entityManagerFactoryBuilder .dataSource(mySqlDataSource())
                .packages("com.eidiko.product_order_microservies.product.entity")
                .build();
    }

    @Bean
    public PlatformTransactionManager mySqlTransactionManager(@Qualifier("mySqlEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }

}
