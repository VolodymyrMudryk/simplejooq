package com.mudryk.simplejooq.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.Connection;

/**
 * @author Volodymyr
 *         Date: 18.11.2016.
 */
@Configuration
@EnableTransactionManagement
public class MainConfiguration {

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/simple_jooq?createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDefaultAutoCommit(true);
        dataSource.setValidationQuery("");
        dataSource.setInitialSize(5);
        dataSource.setMaxIdle(5);
        dataSource.setMaxActive(30);
        dataSource.setMaxWait(120000);
        dataSource.setTestOnBorrow(true);
        dataSource.setLogAbandoned(true);
        dataSource.setDefaultReadOnly(false);
        dataSource.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        return dataSource;
    }
}
