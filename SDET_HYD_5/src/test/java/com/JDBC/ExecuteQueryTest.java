package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQueryTest {
   @Test
   public void executeQueryTest() throws Throwable
   {
	   //step=1 Register the Driver
	   Driver dref=new Driver();
	   DriverManager.registerDriver(dref);
	   //step=2 connect to database
	   Connection con=null;
	   try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		  //step=3 create statement from java program
		 Statement stmt = con.createStatement();
		 //step=4 execute Query
		 ResultSet result = stmt.executeQuery("select*from students_info");
		 while(result.next())
		 {
			 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
 
		 }
		 
	} 
	   catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //step=5 close connection
	   finally {
		   System.out.println("connection closed");
			con.close();
	   }
   }
}
