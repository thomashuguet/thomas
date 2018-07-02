package jeton.beans;

public class Specialite {

	int idSpec;
	String specialite;
	int idUser;
	
	public Specialite(int idSpec, String specialite, int idUser) {
		super();
		this.idSpec = idSpec;
		this.specialite = specialite;
		this.idUser = idUser;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdSpec() {
		return idSpec;
	}
	public void setIdSpec(int idSpec) {
		this.idSpec = idSpec;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
}
