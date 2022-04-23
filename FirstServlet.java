package com.nt.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class FirstServlet extends HttpServlet {
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//create variable
		PrintWriter pw=null;
		String name=null;
		String age=null;
		String add=null;
		HttpSession ses=null;
		//General seting 
		pw=res.getWriter();
		res.setContentType("text/html");
		//read data from form page 
		name=req.getParameter("name");
		age=req.getParameter("age");
		add=req.getParameter("address");
		//create sesion window 
		ses=req.getSession(true);
		//keep form1 data 1 in session attribute 
		ses.setAttribute("name",name);
		ses.setAttribute("address",add);
		ses.setAttribute("age",age);
		//Genrate form 2 dynamically 
		pw.println("<body bgcolor=cyan>");
		pw.println("<center><h1>Provide Your Exp & Skill</h1></center>");
		pw.println("<form action='surl' method='post'>");
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h2>Enter the number of Year exp:");
		pw.println("<input type='text' name='exp'>");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h2><b>Select Skill<b></h2>");
		pw.println("<select name='skill'>");
		pw.println("<option values='java'>JAVA/J2EE</option>");
		pw.println("<option values='.net'>.Net</option>");
		pw.println("<option values='php'>PHP</option>");
		pw.println("<option values='oracle'>Oracle</option>");
		pw.println("<option values='XML'>XML WEBSERVICE</option>");
		pw.println("</select>");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("<td>");
		pw.println("<tr>");
		pw.println("<input type='submit' values='Continue'>");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("</table>");
		pw.println("</body>");
		//close stream 
		pw.close();
	}//end of the method 
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}//end of the  method 

}//end of the class
