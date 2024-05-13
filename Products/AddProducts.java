package com.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String dbUsername="java";
		String dbPassword="java";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url,dbUsername,dbPassword);
			
			String prodId = request.getParameter("prod_id");
			String prodName = request.getParameter("prod_name");
			String category = request.getParameter("category");
			String price = request.getParameter("price");
			String manufactureDateStr = request.getParameter("manufacturing_date");
			
			// Insert into products table
						String Query = "INSERT INTO product (productId,productName, ManufactureDate, productprice, Category) VALUES (?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?,?)";
						pstmt = conn.prepareStatement(Query);
						pstmt.setString(1, prodId);
						pstmt.setString(2, prodName);
						pstmt.setString(5, category);
						pstmt.setString(4, price);
						pstmt.setString(3, manufactureDateStr);
						pstmt.executeUpdate();
						
						
						HttpSession session = request.getSession();
						String userName = (String) session.getAttribute("userId");
						out.println("<h1>Data Added by " + userName+"</h1>");
						
//						RequestDispatcher dispatcher = request.getRequestDispatcher("ExtraActivity");
//						dispatcher.forward(request, response);
						
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}

}
