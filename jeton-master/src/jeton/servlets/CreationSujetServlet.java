package jeton.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jeton.beans.*;
import jeton.services.*;
import jeton.utils.DataConnect;

@WebServlet(urlPatterns = {"/CreationSujet"})
public class CreationSujetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
	Sujet sujet = null;
	Projet projet = null;
	User user = null;
	
	ProjetService projetService = null;
	SujetService sujetService = null;
	UserService userService = null;
	EquipeService equipeService = null;
	
	String nomSujet;
	String description, descriptionCourte;
	String motclef1, motclef2, motclef3;
	int idSujet, idProjet, idUser;

    public CreationSujetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/CreationSujet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//HttpSession session = request.getSession();
		//projet = (Projet)session.getAttribute("projet");
		//user = (User)session.getAttribute("user");
		
		try (Connection connection = DataConnect.getConnection()) {	
			projetService = new ProjetService(connection);
			sujetService = new SujetService(connection);
			
			nomSujet = request.getParameter("nomSujet");
			descriptionCourte = request.getParameter("descriptionCourte");
			description = request.getParameter("description");
			motclef1 = request.getParameter("motclef1");
			motclef2 = request.getParameter("motclef2");
			motclef3 = request.getParameter("motclef3");
			idUser = 1;
			idProjet = 10;
			
			sujet = new Sujet(nomSujet, description, descriptionCourte, motclef1, motclef2, motclef3, idUser, idProjet);
			sujet = sujetService.addSujetProjet(sujet);
		
			response.sendRedirect(request.getContextPath() + "/Projet");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
