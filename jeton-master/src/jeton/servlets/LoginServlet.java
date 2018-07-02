package jeton.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jeton.beans.*;
import jeton.services.*;
import jeton.utils.DataConnect;

@WebServlet(urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	User user = null;
	
	private UserService userService = null;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		try (Connection connection = DataConnect.getConnection()) {	
		userService = new UserService(connection);
		
		String identifiant = request.getParameter("identifiant");	
		String mdp = request.getParameter("mdp");
		
			if(userService.getUserDb(identifiant, mdp) != null) {				
				user = userService.getUserDb(identifiant, mdp);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				response.sendRedirect(request.getContextPath() + "/Accueil");
			}
			else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
			}
		} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
		}
	}

}
