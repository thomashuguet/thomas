package jeton.beans;

public class User {
	
	private int id;
	private String identifiant;
	private String nom;
	private String prenom;
	private String mpd;
	int typeUser;
	private int jetonIntervenant;

	public User(String identifiant, String nom, String prenom, String mdp, int typeUser) {
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.mpd = mdp;
		this.typeUser = typeUser;
	}
	
	public int getJetonIntervenant() {
		return jetonIntervenant;
	}

	public void setJetonIntervenant(int jetonIntervenant) {
		this.jetonIntervenant = jetonIntervenant;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMpd() {
		return mpd;
	}
	public void setMpd(String mpd) {
		this.mpd = mpd;
	}
	public int getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(int typeUser) {
		this.typeUser = typeUser;
	}

}
