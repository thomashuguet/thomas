package jeton.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jeton.beans.*;

public class UserService {

	private Connection connection;
	
	public UserService(Connection connection) {

		this.connection = connection;
	
	}
	
	public User createUser(User user) throws SQLException {

		String query = "insert into user (identifiant, nom, prenom, mdp, type_user) "
			+ " values (?, ?, ?, ?, ?)";

		PreparedStatement psmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		psmt.setString(1, user.getIdentifiant());
		psmt.setString(2, user.getNom());
		psmt.setString(3, user.getPrenom());
		psmt.setString(4, user.getMpd());
		psmt.setLong(5, user.getTypeUser());
		
		psmt.executeUpdate();
		
		ResultSet rs = psmt.getGeneratedKeys();
		
		if (rs.first()) {
			user.setId(rs.getInt(1));			
		}
		
		rs.close();
		psmt.close();
		
		return user;
	}
	
	public User getUserDb(String identifiant, String mdp) throws SQLException {

		User user = null;	
		
		String query = "select * from user where identifiant = ? and mdp = ?";
		
		PreparedStatement psmt = connection.prepareStatement(query);
		
		psmt.setString(1, identifiant);
		psmt.setString(2, mdp);
		
		ResultSet rs = psmt.executeQuery();
		
		if (rs.next()) {
			
			user = new User(rs.getString("identifiant"),
					rs.getString("nom"),
					rs.getString("prenom"),
					rs.getString("mdp"),
					rs.getInt("type_user"));
			
			user.setId(rs.getInt(1));
		}		

		rs.close();
		psmt.close();
		
		return user;

	}
	
	public User getUserFromId(int id) throws SQLException {
		
		User user = null;	
		
		String query = "select * from user where id = ?";
		
		PreparedStatement psmt = connection.prepareStatement(query);
		
		psmt.setInt(1, id);
		
		ResultSet rs = psmt.executeQuery();
		
		if (rs.next()) {
			
			user = new User(rs.getString("identifiant"),
					rs.getString("nom"),
					rs.getString("prenom"),
					rs.getString("mdp"),
					rs.getInt("type_user"));
			
			user.setId(rs.getInt(1));
		}		
		rs.close();
		psmt.close();
		
		return user;
	}
	
	public User addUserEquipe(User user) throws SQLException {

		String query = "insert into equipe (,"
				+ " ) "
				+ " values (?, ?, ?, ?, ?, ?)";

		PreparedStatement psmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		psmt.setInt(1, user.getId());
		psmt.setString(2, user.getNom());
		
		psmt.executeUpdate();
		
		ResultSet rs = psmt.getGeneratedKeys();
		
		if (rs.first()) {
			user.setId(rs.getInt(1));			
		}
		
		rs.close();
		psmt.close();
		
		return user;
	}
	
	public List<User> getList() throws SQLException {
		
		List<User> users = new ArrayList<User>();
		
		Statement statement = connection.createStatement();
		
		String query = "select * from user";
		
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()) {
			
			User user = new User(rs.getString("identifiant"),
					rs.getString("nom"),
					rs.getString("prenom"),
					rs.getString("mdp"),
					rs.getInt("type_user"));
							
			user.setId(rs.getInt(1));						
			
			users.add(user);
		}
		
		return users;
	}
	
}
