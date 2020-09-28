package com.example.restservice;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SpringConfig {

@Bean
public DataSource postgresDataSource() {
System.out.println("Creating Datasource");
BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/devdb");
        dataSource.setUsername("dbuser");
        dataSource.setTestOnBorrow(true);
        dataSource.setTestWhileIdle(true);
        int intialSize = 1;
        dataSource.setInitialSize(1);
        dataSource.setMaxTotal(5);
        dataSource.setMinIdle(1);
        dataSource.setTimeBetweenEvictionRunsMillis(1000L);
        dataSource.setMinEvictableIdleTimeMillis(1000L);

        dataSource.setPassword("Temp1234");
        return dataSource;
}

@Primary
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
System.out.println("Creating JdbcTemplate");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(postgresDataSource());
        return jdbcTemplate;
    }

}
