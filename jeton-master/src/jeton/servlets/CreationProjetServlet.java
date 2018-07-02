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

@WebServlet(urlPatterns = {"/CreationProjet"})
public class CreationProjetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProjetService projetService = null;
	
	Projet projet = null;
	
	int idProjet;
	String nomProjet, description, descriptionCourte;
	String motclef1, motclef2, motclef3;

    public CreationProjetServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/CreationProjet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try (Connection connection = DataConnect.getConnection()) {	
			projetService = new ProjetService(connection);

			nomProjet = request.getParameter("nomProjet");
			description = request.getParameter("description");
			descriptionCourte = request.getParameter("descriptionCourte");
			motclef1 = request.getParameter("motclef1");
			motclef2 = request.getParameter("motclef2");
			motclef3 = request.getParameter("motclef3");
			
			projet = new Projet(nomProjet, description, descriptionCourte, motclef1, motclef2, motclef3);
			projet = projetService.createProjet(projet);
			
			response.sendRedirect(request.getContextPath() + "/ListeProjet");			
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
				
	}

}
