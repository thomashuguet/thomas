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

import jeton.services.ProjetService;
import jeton.utils.DataConnect;

import jeton.beans.*;
import jeton.services.*;

@WebServlet(urlPatterns = {"/Equipe"})
public class EquipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EquipeService equipeService = null;
	UserService userService = null;
	ProjetService projetService = null;
	
	Equipe equipe = null;
	User user = null;
	Projet projet = null;
	
	List<User> users = new ArrayList<User>();
	
	int idEquipe;
	int idChef;
	String nomEquipe;
	String nomChef;
	int nbJeton;
	int idSujet;
	
	
    public EquipeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession();
		//equipe = (Equipe)session.getAttribute("equipe");
		
		
		try (Connection connection = DataConnect.getConnection()) {	
			equipeService = new EquipeService(connection);
			userService = new UserService(connection);
			projetService = new ProjetService(connection);
			//equipe = equipeService.getEquipeFromId(equipe.getIdEquipe());					
			
			// on récupère l'équipe 1 pour tester 
			equipe = equipeService.getEquipeFromId(1);
			projet = projetService.getProjetFromId(10);
			users = equipeService.getListUser(1);
			
			request.setAttribute("users", users);
			request.setAttribute("equipe", equipe);
			request.setAttribute("projet", projet);
		
			this.getServletContext().getRequestDispatcher("/WEB-INF/Equipe.jsp").forward(request, response);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (Connection connection = DataConnect.getConnection()) {
			equipeService = new EquipeService(connection);
			
			nomChef = request.getParameter("nomChef");
			nomEquipe = request.getParameter("nom");
							
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/Equipe");
		
	}

}
