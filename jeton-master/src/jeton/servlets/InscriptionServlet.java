package jeton.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jeton.beans.*;
import jeton.services.*;
import jeton.utils.DataConnect;

@WebServlet(urlPatterns = {"/Inscription"})
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService userService = null;
	
	User user = null;
	
	String identifiant, nom, prenom, mdp;
	int typeUser, jetonIntervenant;
	
    public InscriptionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (Connection connection = DataConnect.getConnection()) {	
			userService = new UserService(connection);
					
			identifiant = request.getParameter("identifiant");
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			mdp = request.getParameter("mdp");
			typeUser = Integer.parseInt(request.getParameter("typeUser"));
			
			if (identifiant.equals("") || (nom.equals("")) || (prenom.equals("")) || (mdp.equals("")) || (typeUser == 0)){
				this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
			}else {
				user = new User(identifiant, nom, prenom, mdp, typeUser);
				user = userService.createUser(user);				
				response.sendRedirect(request.getContextPath() + "/Login");			
			}		
						
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
