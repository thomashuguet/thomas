package jeton.beans;

import java.util.ArrayList;
import java.util.List;

public class Equipe {

	int idEquipe;
	int idChef;
	String nom;
	int nbJeton;
	int idSujet;
	List<User> users = new ArrayList<User>();

	public Equipe(int idChef, String nom, int nbJeton, int idSujet) {
		this.idChef = idChef;
		this.nom = nom;
		this.nbJeton = nbJeton;
		this.idSujet = idSujet;
	}
	
	public int getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	public int getIdChef() {
		return idChef;
	}
	public void setIdChef(int idChef) {
		this.idChef = idChef;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbJeton() {
		return nbJeton;
	}
	public void setNbJeton(int nbJeton) {
		this.nbJeton = nbJeton;
	}

	public int getIdSujet() {
		return idSujet;
	}

	public void setIdSujet(int idSujet) {
		this.idSujet = idSujet;
	}
	
	
}
