package com.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.JdbcConnections;


public class LoginFunctionality extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		JdbcConnections jd=new JdbcConnections();
		HttpSession session=request.getSession();
		session.setAttribute("userId", username);
		try {
			ResultSet rs=jd.validateLogin(username, password);
			if(rs!= null) {
				out.println("<h1> Welcome user " + username + "</h1>");
				out.println("<h1><a href=addProd.html>Add Product</a></h1>");
				out.println("<h1><a href=deleteId.html>DeleteById</a></h1>");
				out.println("<h1><a href=updateProduct.html>UpdateById</a></h1>");
				out.println("<h1><a href=Showproducts.jsp>ShowAll</a></h1>");
				
			}
			else {
				out.println("<h1>Invalid username and password</h1>");
				out.println("<a href='Loginfirst.html'>Click Here Login Again</a>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
