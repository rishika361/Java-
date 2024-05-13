package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JdbcConnections  {
	
	public ResultSet validateLogin(String userName, String Password) throws ClassNotFoundException, SQLException {
		ResultSet rs = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "java");
		PreparedStatement stat = con.prepareStatement("select * from student where fname=? AND lname=?");
		stat.setString(1, userName);
		stat.setString(2, Password);
		rs = stat.executeQuery();
		System.out.println(userName);
		System.out.println(Password);
		if (rs.next())
			return rs;
		else {
			return null;
		}

	}
}
