package com.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
@Repository
public class stockDaoImpl implements stockDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<stock> loadStock()  {
		
		String sql="SELECT * FROM stock89";
		List<stock> list1=jdbcTemplate.query(sql, new mapper());
		return list1;
		
		
	}
	
	

}
