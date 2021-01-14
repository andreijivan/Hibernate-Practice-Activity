package database_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/employee_tracker?useSSL=false&serverTimezone=UTC";
		String userName = "hbstudent";
		String password = "hbstudent";
		
		try {
		System.out.println("Connecting to database: " + jdbcURL);
		
		Connection myConnection = DriverManager.getConnection(jdbcURL, userName, password);
		
		System.out.println("Connection successful!");

	}catch(Exception e){
		e.printStackTrace();
	}

	}

}
