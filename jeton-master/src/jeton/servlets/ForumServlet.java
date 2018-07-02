package jeton.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jeton.beans.*;

@WebServlet(urlPatterns = {"/Forum"})
public class ForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	User user = null;
       
    public ForumServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		user = (User)session.getAttribute("user");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Forum.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		user = (User)session.getAttribute("user");
		
		response.sendRedirect(request.getContextPath() + "/Forum");		
		
	}

}
