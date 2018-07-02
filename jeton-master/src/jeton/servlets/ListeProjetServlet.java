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

import jeton.services.ProjetService;
import jeton.utils.DataConnect;

import jeton.beans.*;
import jeton.services.*;

@WebServlet(urlPatterns = {"/ListeProjet"})
public class ListeProjetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProjetService projetService = null;
	UserService userService = null;
	
	Projet projet = null;
	User user = null;
	
	List<Projet> projets = new ArrayList<Projet>();
	
	int idProjet;
	String nomProjet, description, descriptionCourte;
	String motclef1, motclef2, motclef3;
	int cptPersonne;

    public ListeProjetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (Connection connection = DataConnect.getConnection()) {	
			projetService = new ProjetService(connection);
			projets = projetService.getList();
			
			request.setAttribute("projets", projets);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/ListeProjet.jsp").forward(request, response);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
