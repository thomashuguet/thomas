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

@WebServlet(urlPatterns = {"/CreationEquipe"})
public class CreationEquipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EquipeService equipeService = null;
	UserService userService = null;
	
	Equipe equipe = null;
	User user = null;
	
	int idEquipe;
	int idChef;
	String nomEquipe;
	int nbJeton;
	int idSujet;
	String identifiantUser;
	
	List<User> users = new ArrayList<User>();

    public CreationEquipeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/CreationEquipe.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		//equipe = (Equipe)session.getAttribute("equipe");		
		
		try (Connection connection = DataConnect.getConnection()) {	
			equipeService = new EquipeService(connection);
			userService = new UserService(connection);
					
			//
			idChef = user.getId();
			nomEquipe = request.getParameter("nom");
			nbJeton = Integer.parseInt(request.getParameter("nbJeton"));
			idEquipe = Integer.parseInt(request.getParameter("idEquipe"));
			//idSujet = Integer.parseInt(request.getParameter("idSujet"));
			identifiantUser = request.getParameter("user");
			
			user = userService.getUserFromId(user.getId());
			
			equipe = new Equipe(idChef, nomEquipe, 0, 0);
			equipe = equipeService.createEquipe(equipe);
			
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
