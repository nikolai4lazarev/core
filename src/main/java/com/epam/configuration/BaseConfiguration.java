package com.epam.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class BaseConfiguration {

//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setPassword("postgres");
//        driverManagerDataSource.setUsername("postgres");
//        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
//        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/lab");
//        return driverManagerDataSource;
//    }
//
//    @Bean
//    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }

}
