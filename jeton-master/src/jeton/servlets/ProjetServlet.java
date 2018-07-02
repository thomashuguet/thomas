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

import jeton.services.EquipeService;
import jeton.services.ProjetService;
import jeton.services.SujetService;
import jeton.services.UserService;
import jeton.utils.DataConnect;

import jeton.services.*;
import jeton.beans.*;

@WebServlet(urlPatterns = {"/Projet"})
public class ProjetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProjetService projetService = null;
	SujetService sujetService = null;
	
	List<Sujet> sujets = new ArrayList<Sujet>();
	
	Projet projet = null;
	Sujet sujet = null;
	User user = null;
	
	int idProjet;
	String description, descriptionCourte;
	String motclef1, motclef2, motclef3;
	String nom;
	
	
    public ProjetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession();
		//projet = (Projet)session.getAttribute("projet");
		
		try (Connection connection = DataConnect.getConnection()) {	
			projetService = new ProjetService(connection);
			sujetService = new SujetService(connection);
			projet = projetService.getProjetFromId(10);

			//on récupère les info du projet
			description = projet.getDescription();
			descriptionCourte = projet.getDescriptionCourte();
			idProjet = projet.getIdProjet();
			motclef1 = projet.getMotclef1();
			motclef2 = projet.getMotclef2();
			motclef3 = projet.getMotclef3();
			nom = projet.getNom();
			
			request.setAttribute("projet", projet);
			
			// on récupère les sujets du projet
			sujets = sujetService.getList();
			
			request.setAttribute("sujets", sujets);
		
			this.getServletContext().getRequestDispatcher("/WEB-INF/Projet.jsp").forward(request, response);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
