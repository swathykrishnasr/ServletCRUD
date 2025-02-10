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
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User u=new User();
		u=Userdao.userDetails(email,password);
		if (u!=null&&u.getId()>0) {
		    if (u.getUtype().equals("admin")) 
		    {
		        response.sendRedirect("Adminhome");
		    } 
		    else 
		    {
		        request.setAttribute("user", u);
//		        response.sendRedirect("Userhome");
		        request.getRequestDispatcher("Userhome").forward(request, response);
		    }
		} 
		else
		{
		    out.print("<h2>Invalid! Please login again.</h2>");
		    request.getRequestDispatcher("login.html").include(request, response);
		}

//		if(u!=null)
//		{
//		out.println("<h2>Welcome "+u.getFname()+" "+u.getLname()+"</h2><br><br>");
//		out.println("<h3>Firstname: "+u.getFname()+"</h3><br>");
//		out.println("<h3>Lastname: "+u.getLname()+"</h3><br>");
//		out.println("<h3>State:"+u.getState()+"<h3>");
//		out.println("<h3>Emailid:"+u.getEmail()+"<h3>");
//		
//		}
//		else 
//		{
//            out.print("<h2>Invalid! Please login again.</h2>");
//            request.getRequestDispatcher("login.html").include(request, response);
//		}
		
	}

}

