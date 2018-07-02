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

@WebServlet(urlPatterns = {"/Accueil"})
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<User> users = new ArrayList<User>();
	List<Projet> projets = new ArrayList<Projet>();
	List<Equipe> equipes = new ArrayList<Equipe>();
	List<Sujet> sujets = new ArrayList<Sujet>();
	
	User user = null;
	Projet projet = null;
	Equipe equipe = null;
	Sujet sujet = null;
	
	private UserService userService = null;
	private ProjetService projetService = null;
	private EquipeService equipeService = null;
	private SujetService sujetService = null;
       
    public AccueilServlet() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		user = (User)session.getAttribute("user");
		
		try (Connection connection = DataConnect.getConnection()) {	
		userService = new UserService(connection);
		equipeService = new EquipeService(connection);
		projetService = new ProjetService(connection);
		sujetService = new SujetService(connection);
		

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		response.sendRedirect(request.getContextPath() + "/Accueil");
		
	}

}
