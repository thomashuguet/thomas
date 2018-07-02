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

@WebServlet(urlPatterns = {"/Sujet"})
public class SujetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Sujet sujet = null;
	Projet projet = null;
	User user = null;
	Equipe equipe = null;
	
	ProjetService projetService = null;
	SujetService sujetService = null;
	UserService userService = null;
	EquipeService equipeService = null;
	
	String nomSujet, nomUser;
	String description, descriptionCourte;
	String motclef1, motclef2, motclef3;
	int idSujet, idProjet, idUser;
	
	List<Equipe> equipes = new ArrayList<Equipe>();
	List<User> users = new ArrayList<User>();
	
    public SujetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		projet = (Projet)session.getAttribute("projet");
		user = (User)session.getAttribute("user");
		sujet = (Sujet)session.getAttribute("sujet");
		
		try (Connection connection = DataConnect.getConnection()) {	
			projetService = new ProjetService(connection);
			sujetService = new SujetService(connection);
			//projet = projetService.getProjetFromId(projet.getIdProjet());
			// on récupère le projet 1 pour tester
			projet = projetService.getProjetFromId(10);
			idProjet = projet.getIdProjet();
			
			//nomUser = user.getNom();
			// on récupère le user 1 pour tester
			user = userService.getUserFromId(1);
			idUser = user.getId();
			
			// on récupère le sujet 1 pour tester
			sujet = sujetService.getSujetFromId(1);
			
			nomSujet = sujet.getNom();
			descriptionCourte = sujet.getDescriptionCourte();
			description = sujet.getDescription();
			motclef1 = sujet.getMotclef1();
			motclef2 = sujet.getMotclef2();
			motclef3 = sujet.getMotclef3();
			
			// on récupère la liste des équipes de CE sujet
			// equipes = equipeService.getListUser(idEquipe)
			
			// on récupère la liste des équipes du sujet 1 pour tester
			equipe = equipeService.getEquipeFromId(1);
			users = equipeService.getListUser(1);
			
			request.setAttribute("nomSujet", nomSujet);
			request.setAttribute("description", description);
			request.setAttribute("descriptionCourte", descriptionCourte);
			request.setAttribute("motclef1", motclef1);
			request.setAttribute("motclef2", motclef2);
			request.setAttribute("motclef3", motclef3);
			request.setAttribute("nomUser", nomUser);
			
			response.sendRedirect(request.getContextPath() + "/Accueil");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Sujet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
