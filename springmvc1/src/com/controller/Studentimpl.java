package com.controller;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class Studentimpl implements Student {
	private JdbcTemplate jdbcTemplate=new JdbcTemplate(getDataSource());
	@Override
	public void insert(reg re) {
		String sql="INSERT INTO User4 VALUES(?,?,?)";
		Object[] arg= {re.getUsername(),re.getPassword(),re.getName()};
		jdbcTemplate.update(sql,arg);
	}
	public DataSource getDataSource() {
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String username="system";
		String password="#Padmaja71";
		DataSource dataSource=new DriverManagerDataSource(url,username,password);
		return dataSource;
	}
}
