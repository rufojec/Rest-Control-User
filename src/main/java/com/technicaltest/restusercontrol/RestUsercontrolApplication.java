package com.technicaltest.restusercontrol;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.technicaltest.restusercontrol.model.User;

@SpringBootApplication()
//@ComponentScan(basePackages = "com.technicaltest.restusercontrol.services.impl,com.technicaltest.restusercontrol.repository")
public class RestUsercontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestUsercontrolApplication.class, args);
	}

}
