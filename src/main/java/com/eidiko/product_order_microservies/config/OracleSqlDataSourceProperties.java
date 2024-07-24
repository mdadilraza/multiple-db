package com.eidiko.product_order_microservies.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "oracleSqlEntityManagerFactoryBean",
basePackages = "com.eidiko.product_order_microservies.customer.repository",
transactionManagerRef = "oracleTransactionManager")
public class OracleSqlDataSourceProperties {

    @Bean
    @ConfigurationProperties("spring.datasource.oracle")
    public DataSourceProperties oracleDataSourceProperties(){
        return new DataSourceProperties();
    }

  @Primary
    @Bean
    public DataSource oracleDataSource(){
        return oracleDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean oracleSqlEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder){
        return entityManagerFactoryBuilder .dataSource(oracleDataSource())
                .packages("com.eidiko.product_order_microservies.customer.entity")
                .build();
    }

    @Bean
    public PlatformTransactionManager oracleTransactionManager(@Qualifier("oracleSqlEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryBean.getObject()));
    }
}
