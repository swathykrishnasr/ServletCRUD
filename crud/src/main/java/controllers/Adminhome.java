package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.User;
import pack.Userdao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class Adminhome
 */
@WebServlet("/Adminhome")
public class Adminhome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminhome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<User> us = Userdao.viewAll();
        out.println("<h2>Welcome</h2>");
        out.println("<h2>List of all registered users</h2>");
        out.println("<table border='1'");
        out.println("<tr><th>Id</th><th>Fname</th><th>Lname</th><th>State</th><th>Emailid</th><th>Password</th><th>Actions</th></tr>");
        for (User user : us) 
        {
        	out.println("<tr>");
            out.println("<td>" +user.getId()+"</td>");
            out.println("<td>" +user.getFname()+"</td>");
            out.println("<td>" + user.getLname() +"</td>");
            out.println("<td>"+ user.getState()+"</td>");
            out.println("<td>"+user.getEmail()+"</td>");
            out.println("<td>"+user.getPassword()+"</td>");
            out.println("<td>");
            out.println("<a href='Edit?id="+user.getId()+"'>Edit</a>");
            out.println("<a href='Delete?id="+user.getId()+"'>Delete</a>");
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
