package com.nt.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import com.sun.corba.se.pept.transport.Connection;
public class ThirdServlet extends HttpServlet {
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//create varible 
		PrintWriter pw=null;
		String city=null;
		String sal=null;
		String name=null;
		String age=null;
		String exp=null;
		String skils=null;
		HttpSession ses=null;
		String add=null;
		Connection con=null;
		PreparedStatement ps=null;
		int i=0;
		//General seting 
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form 3 data 
		city=req.getParameter("city");
		sal=((ServletRequest) res).getParameter("sal");
		ses=req.getSession();
		//read form 1 data 
		name=(String)ses.getAttribute("name");		
		add=(String)ses.getAttribute("addr");		
		age=(String)ses.getAttribute("age");		
		exp=(String)ses.getAttribute("exp");
		skils=(String)ses.getAttribute("skils");
		//insert form1 ,form2,form3 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=(Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
			ps=((java.sql.Connection) con).prepareStatement("insert into info values(?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, add);
			ps.setLong(3,Integer.parseInt(age) );
			ps.setLong(4,Integer.parseInt(exp) );
			ps.setString(5, skils);
			ps.setString(6,city);
			ps.setString(7, sal);
			i=ps.executeUpdate();
			//invalidate the session
			ses.invalidate();
			if(i>0) {
				pw.println("<body>");
			pw.println("<h1>insert data</h1>");
			pw.println("<a href='persone.html'>Home</a>");
			pw.println("</body>");
			}//end of the if block
			else {
				pw.println("<body>");
				pw.println("<h1>Try Agine </h1>");
				pw.println("<a href='persone.html'>Home</a>");
			pw.println("</body>");
			}//end else block
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("<body>");
			pw.println("<h1>Try Agine </h1>");
			pw.println("<a href='persone.html'>Home</a>");
		pw.println("</body>");
		}//end of the catch block
	}//end of the method 
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}//end of the method 

}//end of the class
