package jeton.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jeton.beans.*;

public class ProjetService {

	private Connection connection;
	
	public ProjetService(Connection connection) {

		this.connection = connection;
	}
	
	public Projet getProjetFromId(int id) throws SQLException {
		
		Projet projet = null;	
		
		String query = "select * from projet where id_projet = ?";
		
		PreparedStatement psmt = connection.prepareStatement(query);
		
		psmt.setInt(1, id);
		
		ResultSet rs = psmt.executeQuery();
		
		if (rs.next()) {
			
			projet = new Projet(rs.getString("nom"),
					rs.getString("description"),
					rs.getString("description_courte"),
					rs.getString("mot_clef1"),
					rs.getString("mot_clef2"),
					rs.getString("mot_clef3"));
			
			projet.setIdProjet(rs.getInt(1));
		}		
		rs.close();
		psmt.close();
		
		return projet;
	}
	
	public Projet createProjet(Projet projet) throws SQLException {

		String query = "insert into projet (nom, description, "
				+ " description_courte, mot_clef1, mot_clef2, mot_clef3) "
				+ " values (?, ?, ?, ?, ?, ?)";

		PreparedStatement psmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		psmt.setString(1, projet.getNom());
		psmt.setString(2, projet.getDescription());
		psmt.setString(3, projet.getDescriptionCourte());
		psmt.setString(4, projet.getMotclef1());
		psmt.setString(5, projet.getMotclef2());
		psmt.setString(6, projet.getMotclef3());
		
		psmt.executeUpdate();
		
		ResultSet rs = psmt.getGeneratedKeys();
		
		if (rs.first()) {
			projet.setIdProjet(rs.getInt(1));			
		}
		
		rs.close();
		psmt.close();
		
		return projet;
	}
	
	public List<Projet> getList() throws SQLException {
		
		List<Projet> projets = new ArrayList<Projet>();
		
		Statement statement = connection.createStatement();
		
		String query = "select * from projet";
		
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()) {
			
			Projet projet = new Projet(rs.getString("nom"),
					rs.getString("description"),
					rs.getString("description_courte"),
					rs.getString("mot_clef1"),
					rs.getString("mot_clef2"),
					rs.getString("mot_clef3"));
							
			projet.setIdProjet(rs.getInt(1));						
			
			projets.add(projet);
		}
		
		return projets;
	}
	
}
