package jeton.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jeton.beans.*;

public class SujetService {

	private Connection connection;
	
	public SujetService(Connection connection) {

		this.connection = connection;
	
	}		
	
	public Sujet getSujetFromId(int id) throws SQLException {
		
		Sujet sujet = null;	
		
		String query = "select * from sujet where id = ?";
		
		PreparedStatement psmt = connection.prepareStatement(query);
		
		psmt.setInt(1, id);
		
		ResultSet rs = psmt.executeQuery();
		
		if (rs.next()) {
			
			sujet = new Sujet(rs.getString("nom"),
					rs.getString("description"),
					rs.getString("description_courte"),
					rs.getString("mot_clef1"),
					rs.getString("mot_clef2"),
					rs.getString("mot_clef3"),
					rs.getInt("id_user"),
					rs.getInt("id_projet"));
			
			sujet.setId(rs.getInt(1));
		}		
		rs.close();
		psmt.close();
		
		return sujet;
	}
	
	public Sujet addSujetProjet(Sujet sujet) throws SQLException {

		String query = "insert into projet (id_sujet, nom, description,"
				+ " description_courte, mot_clef1, mot_clef2, mot_clef3, "
				+ "id_user, id_projet)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement psmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		psmt.setInt(1, sujet.getId());
		psmt.setString(2, sujet.getNom());
		psmt.setString(3, sujet.getDescription());
		psmt.setString(4, sujet.getDescriptionCourte());
		psmt.setString(5, sujet.getMotclef1());
		psmt.setString(6, sujet.getMotclef2());
		psmt.setString(7, sujet.getMotclef3());
		psmt.setInt(8, sujet.getIdUser());
		psmt.setInt(9,  sujet.getIdProjet());
		
		ResultSet rs = psmt.getGeneratedKeys();
		
		if (rs.first()) {
			sujet.setId(rs.getInt(1));			
		}
		
		rs.close();
		psmt.close();
		
		return sujet;
	}
	
	public List<Sujet> getList() throws SQLException {
		
		List<Sujet> sujets = new ArrayList<Sujet>();
		
		Statement statement = connection.createStatement();
		
		String query = "select * from sujet";
		
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()) {
			
			Sujet sujet = new Sujet(rs.getString("nom"),
					rs.getString("description"),
					rs.getString("description_courte"),
					rs.getString("mot_clef1"),
					rs.getString("mot_clef2"),
					rs.getString("mot_clef3"),
					rs.getInt("id_user"),
					rs.getInt("id_projet"));
							
			sujet.setId(rs.getInt(1));						
			
			sujets.add(sujet);
		}
		
		return sujets;
	}
	
}
