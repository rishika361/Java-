package com.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class updateProduct extends HttpServlet {
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
			String query="Update product set productname=?, manufacturedate=?, productprice=?, category=? where productid=?";
			PreparedStatement ps=conn.prepareStatement(query);
			
			String pId=request.getParameter("pId");
			String prodName=request.getParameter("prod_name");
			String manufacturedate=request.getParameter("manufacturing_date");
			String price=request.getParameter("price");
			String category=request.getParameter("category");
			
			System.out.println("pId: " + pId);
	        System.out.println("prodName: " + prodName);
	        System.out.println("manufacturedate: " + manufacturedate);
	        System.out.println("price: " + price);
	        System.out.println("category: " + category);

			if (prodName != null && category != null && price != null && manufacturedate != null
					&& pId != null) {
				ps.setInt(5, Integer.parseInt(pId));
				ps.setString(1, prodName);
				ps.setDate(2, Date.valueOf(manufacturedate));
	            ps.setString(3, price);
				ps.setString(4, category);
				
				
			  int rowsupdated=ps.executeUpdate();
			  if(rowsupdated>0) {
					out.println("<h1>Records updated successfully</h1>");
				}else {
					out.println("<h1>Record not updated</h1>");
				}
		}else {
			out.println("<h1>Invalid input data</h1>");
		}
		}	catch (Exception e) {
			e.printStackTrace();
		}
	}
}


