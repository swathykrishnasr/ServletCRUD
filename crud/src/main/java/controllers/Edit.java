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
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id=Integer.parseInt(request.getParameter("id"));
        User u=Userdao.edit(id);
        out.print("<form action='Update'>");
        out.print("<input type='hidden' name='id' value='"+u.getId()+"'>");
        out.print("<input type='text' name='fname' value='"+u.getFname()+"'>");
        out.print("<input type='text' name='lname' value='"+u.getLname()+"'>");
        out.print("<select name='state'>"+"<option>Kerala</option>"+"<option>Karnataka</option>"+
                "<option>Tamil Nadu</option>"+"<option>Andhra Pradesh</option>"+"</select>");

        out.print("<input type='email' name='email' value='"+u.getEmail()+"'>");
        out.print("<input type='password' name='password' value='"+u.getPassword()+"'>");
        out.print("<button type='submit'>ok</button>");
        out.print("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
