package com.nt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//create variable 
		PrintWriter pw=null;
		String exp=null;
		String skils=null;
		HttpSession ses=null;
		//General seting 
		pw=res.getWriter();
		res.setContentType("text/html");
		//read from data 
		exp=req.getParameter("exp");
		skils=req.getParameter("skils");
		//Acdess to session object 
		ses=req.getSession();
		ses.setAttribute("exp",exp);
		ses.setAttribute("skils",skils);
		//generate form3 dynamically 
		pw.println("<body>");
		pw.println("<h1>Provide city and salary </h1>");
		pw.println("<form action='turl' method='post'>");
		pw.println("<table>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h1>Enter the preference city :</h1>");
		pw.println("<input type='text' name='city'>");
		pw.println("</td>");
		pw.println("</tr>");
		
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<h1>Enter the Expected salary :</h1>");
		pw.println("<input type='text' name='sal'>");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>");
		pw.println("<input type='submit' values='submit'>");
		pw.println("</td>");
		pw.println("</tr>");
		pw.println("</table></form></body>");
		//close stream
		pw.close();
		
	}//end of the method 
	public  void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}//end of teh method 

}//end of the class
