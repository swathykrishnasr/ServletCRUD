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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		PrintWriter out=response.getWriter();
		
		    User u=new User();
		    u.setId(Integer.parseInt(request.getParameter("id")));
		    u.setFname(request.getParameter("fname"));
		    u.setLname(request.getParameter("lname"));
		    u.setState(request.getParameter("state"));
		    u.setEmail(request.getParameter("email"));
		    u.setPassword(request.getParameter("password"));
		    int i = Userdao.updateUser(u);
		    if (i> 0) 
		    {
		        response.sendRedirect("Adminhome");  
		    } 
		    else
		    {
		    out.println("error");	
		    }
		  

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
