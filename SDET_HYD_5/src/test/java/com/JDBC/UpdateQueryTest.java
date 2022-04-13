package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class UpdateQueryTest {
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
   int result=stmt.executeUpdate("insert into students_info (regno, firstname, middlename, lastname) values('4', 'ram','gowda', 'h')");
         if(result==1)
         {
				   System.out.println("Data stroed inside the table");
         }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     finally
		     {
                  con.close();
		     }
	   }
	
}