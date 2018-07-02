package jeton.beans;

import java.util.ArrayList;
import java.util.List;

public class Projet {

	int idProjet;
	String nom;
	String description;
	String descriptionCourte;
	String motclef1;
	String motclef2;
	String motclef3;
	List<Sujet> sujets = new ArrayList<Sujet>();
	
	public Projet(String nom, String description, String descriptionCourte, String motclef1,
			String motclef2, String motclef3) {
		this.nom = nom;
		this.description = description;
		this.descriptionCourte = descriptionCourte;
		this.motclef1 = motclef1;
		this.motclef2 = motclef2;
		this.motclef3 = motclef3;
	}
	
	public int getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescriptionCourte() {
		return descriptionCourte;
	}
	public void setDescriptionCourte(String descriptionCourte) {
		this.descriptionCourte = descriptionCourte;
	}
	public String getMotclef1() {
		return motclef1;
	}
	public void setMotclef1(String motclef1) {
		this.motclef1 = motclef1;
	}
	public String getMotclef2() {
		return motclef2;
	}
	public void setMotclef2(String motclef2) {
		this.motclef2 = motclef2;
	}
	public String getMotclef3() {
		return motclef3;
	}
	public void setMotclef3(String motclef3) {
		this.motclef3 = motclef3;
	}
	
}
