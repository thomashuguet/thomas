package jeton.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jeton.beans.*;

public class EquipeService {

	private Connection connection;
	
	public EquipeService(Connection connection) {

		this.connection = connection;
	}	
	
	public Equipe getEquipeFromId(int id) throws SQLException {
		
		Equipe equipe = null;	
		
		String query = "select * from equipe where id_equipe = ?";
		
		PreparedStatement psmt = connection.prepareStatement(query);
		
		psmt.setInt(1, id);
		
		ResultSet rs = psmt.executeQuery();
		
		if (rs.next()) {
			
			equipe = new Equipe(rs.getInt("id_chef"),
					rs.getString("nom"),
					rs.getInt("nb_jeton"),
					rs.getInt("id_sujet"));
			
			equipe.setIdEquipe(rs.getInt(1));
		}		
		rs.close();
		psmt.close();
		
		return equipe;
	}
	
	public Equipe createEquipe(Equipe equipe) throws SQLException {

		String query = "insert into equipe (id_equipe, id_projet, id_chef,"
				+ " nom, nb_jeton, id_sujet) "
				+ " values (?, ?, ?, ?, ?, ?)";

		PreparedStatement psmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		psmt.setInt(1, equipe.getIdEquipe());
		psmt.setString(2, equipe.getNom());
		
		psmt.executeUpdate();
		
		ResultSet rs = psmt.getGeneratedKeys();
		
		if (rs.first()) {
			equipe.setIdEquipe(rs.getInt(1));			
		}
		
		rs.close();
		psmt.close();
		
		return equipe;
	}
	
	public List<Equipe> getList() throws SQLException {
		
		List<Equipe> equipes = new ArrayList<Equipe>();
		
		Statement statement = connection.createStatement();
		
		String query = "select * from equipe";
		
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()) {
			
			Equipe equipe = new Equipe(rs.getInt("id_chef"),
					rs.getString("nom"),
					rs.getInt("nb_jeton"),
					rs.getInt("id_sujet"));
							
			equipe.setIdEquipe(rs.getInt(1));						
			
			equipes.add(equipe);
		}
		
		return equipes;
	}
	
	public List<User> getListUser(int idEquipe) throws SQLException {
		List<User> users = new ArrayList<User>();		
		
		String query = "select identifiant, nom, prenom, mdp, type_user from user "
		+ "inner join appartenir_a "
		+ "ON "
		+ "user.id_user = appartenir_a.id_user "
		+ "and id_equipe = ?";
		
		PreparedStatement psmt = connection.prepareStatement(query);
		
		psmt.setInt(1, idEquipe);
		
		ResultSet rs = psmt.executeQuery();
		
		while(rs.next()) {
			
			User user = new User(rs.getString("identifiant"),
					rs.getString("nom"),
					rs.getString("prenom"),
					rs.getString("mdp"),
					rs.getInt("type_user"));
			
			users.add(user);
			
		}
		
		return users;
	}
	
}
