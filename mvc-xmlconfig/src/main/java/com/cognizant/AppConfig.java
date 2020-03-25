package com.cognizant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;

@Configuration
@ComponentScan("com.cognizant")
@PropertySource("classpath:db.properties")
public class AppConfig {
	@Autowired
	Environment environment;

	private final String DEV_URL = "DEV_URL";
	private final String DEV_USER = "DEV_USERNAME";
	private final String DEV_DRIVER = "DEV_DRIVER_CLASS";
	private final String DEV_PASSWORD = "DEV_PASSWORD";
	
	@Bean
	public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(environment.getProperty("DEV_DRIVER_CLASS"));
        ds.setUrl(environment.getProperty("DEV_URL"));
        ds.setUsername(environment.getProperty("DEV_USERNAME"));
        ds.setPassword(environment.getProperty("DEV_PASSWORD"));
        return ds;
	}
}
