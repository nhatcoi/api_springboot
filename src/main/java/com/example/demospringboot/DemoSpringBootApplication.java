package com.example.demospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootApplication.class, args);
    }
}
//spring.datasource.url=jdbc:mysql://localhost::3306/employees_management_system
//spring.datasource.username=root
//spring.datasource.password=nhatcoi2004
//
//spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
//spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
//spring.jpa.hibernate.ddl-auto=update
//
//
//## spring.datasource.url : to be setting up the URL for connecting to database in Springboot application
//## jdbc:mysql : This is the JDBC connection URL prefix for MySQL databases. JDBC-Java Database Connectivity allows Java interact with db
//## localhost : hostname of db server
//## 3306 : Specifies the port number on which the MySQL db. The default port for MySQL is 3306
//## employees_management_system : name of database to which the application will connect