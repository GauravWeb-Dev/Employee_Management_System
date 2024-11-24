package com.solution.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
      static {
    		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		//	System.out.println("Driver loaded succefully");
			
      }
      
      public static Connection getConnection() throws SQLException, IOException {
    		Properties p = new Properties();
    	    p.load(new FileReader("C:\\Users\\Ani\\Downloads\\WorkSpaces\\Servlet Workspace\\Employee Management System\\src\\main\\java\\com\\solution\\properties\\Application.properties"));
    		
			Connection connection = DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("password"));
			//System.out.println("Connection established Succesfully");
			 return connection;
      }
      
      public static void cleanUp(Connection connection , Statement statement, ResultSet resultSet) throws SQLException {
    	  if(resultSet != null) 
    	      resultSet.close();
    	  
    	  if(statement != null) 
			statement.close();
    	  
    	  if(connection != null) 
			connection.close();
    	  
			//System.out.println("Connection closed");
      }
}
