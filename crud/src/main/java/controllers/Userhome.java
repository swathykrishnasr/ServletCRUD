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

/**
 * Servlet implementation class Userhome
 */
@WebServlet("/Userhome")
public class Userhome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userhome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 User user = (User) request.getAttribute("user");

	        if (user != null) {
	            out.println("<h2>Welcome " + user.getFname() + " " + user.getLname() + "</h2>");
	            out.println("<h3>Firstname: " + user.getFname() + "</h3>");
	            out.println("<h3>Lastname: " + user.getLname() + "</h3>");
	            out.println("<h3>State: " + user.getState() + "</h3>");
	            out.println("<h3>Email: " + user.getEmail() + "</h3>");
	        } else
	        {
	            out.println("<h2>Error</h2>");
	        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 User user = (User) request.getAttribute("user");

	        if (user != null) {
	            out.println("<h2>Welcome " + user.getFname() + " " + user.getLname() + "</h2>");
	            out.println("<h3>Firstname: " + user.getFname() + "</h3>");
	            out.println("<h3>Lastname: " + user.getLname() + "</h3>");
	            out.println("<h3>State: " + user.getState() + "</h3>");
	            out.println("<h3>Email: " + user.getEmail() + "</h3>");
	        } else
	        {
	            out.println("<h2>Error</h2>");
	        }
		
	}

}
