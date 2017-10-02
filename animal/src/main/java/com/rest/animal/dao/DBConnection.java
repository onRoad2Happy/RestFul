package com.rest.animal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public Connection getConnection() throws 
	InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		String url="jdbc:mysql://localhost:3306/Bookstore";
		Connection connection=null;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection=DriverManager.getConnection(url,"root","verma");	
		return connection;
	}
}
