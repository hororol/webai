package com.example.springboot230703.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyConf {

    @Bean
    public DataSource dataSource(){
        BasicDataSource dbs = new BasicDataSource();
        dbs.setUrl("jdbc:mysql://localhost:3307/mydb");
        dbs.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dbs.setUsername("root");
        dbs.setPassword("1234");
        return dbs;
    }
}
