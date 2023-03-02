package com.chaiwala.webApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChaiServlet extends HttpServlet{
    protected void  doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
    	String Chaibrand = req.getParameter("cb");
    	String price = req.getParameter("cp");
    	int ChaiPrice	=Integer.parseInt(price);
    	String Chaiqty = req.getParameter("qt");
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=12345");
    		PreparedStatement pstmt = con.prepareStatement("insert into chai.info values(?,?,?)");
    		pstmt.setString(1, Chaibrand);
		    pstmt.setInt(2, ChaiPrice);
		    pstmt.setString(3, Chaiqty);
		    
		    pstmt.executeUpdate();
    	
    	
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
    }
}
