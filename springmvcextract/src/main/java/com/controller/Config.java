package com.controller;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.controller"})
public class Config {
@Bean
	public InternalResourceViewResolver viewResolver() {
	InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
	viewResolver.setPrefix("/WEB-INF/views/");
	viewResolver.setSuffix(".jsp");
	return viewResolver;
}
@Bean
public JdbcTemplate jdbcTemplate() {
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
	return jdbcTemplate;
}
@Bean
public DataSource dataSource()
{
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setUsername("system");
	dataSource.setPassword("#Padmaja71");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	return dataSource;
}
}
