package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
@Controller
public class Usedao {
	static Connection con;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","#Anurag123");
			System.out.println("Connected....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	public String createUser(String username,String password,String name) {
	String result="";
	try{
		PreparedStatement ps = con.prepareStatement("insert into user4 values(?,?,?)");
		ps.setString(1,username);
		ps.setString(2,password);
		ps.setString(3, name);
		int rows=ps.executeUpdate();
		if(rows>0)
			result="<a href='login.jsp'>Login</a>";
		else
			result="not created";
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}
}
