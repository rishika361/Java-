package com.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class deleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String dbUsername="java";
		String dbPassword="java";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(url,dbUsername,dbPassword);
			int Id= Integer.parseInt(request.getParameter("rId"));
			
			String query="Delete from product where productId=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, Id);
			int rows=ps.executeUpdate();
			
		     if(rows==1) {
		    	 out.println("<h1>Record deleted successfully</h1>");
		     }else {
		    	 out.println("<h1>Records not deleted");
		     }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
