<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
   <tr>
   <th> Product Id</th>
   <th> Product Name</th>
   <th> Manufactured on</th>
   <th> Product Price</th>
   <th> Category</th>
   </tr>
   
    <% 
   try{
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","java","java");
      String query= "select * from Product";
      Statement stmt= conn.createStatement();
      ResultSet rs=stmt.executeQuery(query);
      
      while(rs.next()){%>
    	  
    	  <tr>
    	  <td> <%= rs.getString(1) %></td>
    	  <td> <%= rs.getString(2) %></td>
    	  <td> <%= rs.getString(3) %></td>
    	  <td> <%= rs.getString(4) %></td>
    	  <td> <%= rs.getString(5) %></td>
    	  </tr>
      <% }
   }catch(Exception e){
	   e.printStackTrace();
   }
   %>
   
   </table>
   
</body>
</html>