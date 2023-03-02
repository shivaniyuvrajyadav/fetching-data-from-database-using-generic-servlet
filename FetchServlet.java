package com.ty.techApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FetchServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fid = req.getParameter("id");
	int id	=Integer.parseInt(fid);
	PrintWriter  out =res.getWriter();
	String qry="select* from emp.info where id=?";
	out.println("<html><body>"+id+"<body></html>");	
	    
	    	
	    
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=12345");
			 PreparedStatement pstmt = con.prepareStatement(qry);
			 pstmt.setInt(1, id);
			 ResultSet rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 
				 String name = rs.getString(2);
				 String role = rs.getString(3);
				 
				 out.println("<html>");
				 System.out.println(id+" "+name+" "+role);
			 }
			 else {
				 System.out.println("invalid id:->"+id);
				 out.println("<html><body>");
				 out.println("id is not present");
				 out.println("<html><body>");
			 }
	    
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}

}
