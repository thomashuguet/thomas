package jeton.beans;

import java.util.Date;

public class Mail {
	
	int idMail;
	String sujet;
	String corps;
	Date dateEnvoi;
	boolean lu;
	int idUserEmetteur;
	int idUserRecepteur;
	
	public Mail(int idMail, String sujet, String corps, Date dateEnvoi, boolean lu, int idUserEmetteur,
			int idUserRecepteur) {
		this.idMail = idMail;
		this.sujet = sujet;
		this.corps = corps;
		this.dateEnvoi = dateEnvoi;
		this.lu = lu;
		this.idUserEmetteur = idUserEmetteur;
		this.idUserRecepteur = idUserRecepteur;
	}
	
	public int getIdUserEmetteur() {
		return idUserEmetteur;
	}
	public void setIdUserEmetteur(int idUserEmetteur) {
		this.idUserEmetteur = idUserEmetteur;
	}
	public int getIdUserRecepteur() {
		return idUserRecepteur;
	}
	public void setIdUserRecepteur(int idUserRecepteur) {
		this.idUserRecepteur = idUserRecepteur;
	}
	public int getIdMail() {
		return idMail;
	}
	public void setIdMail(int idMail) {
		this.idMail = idMail;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getCorps() {
		return corps;
	}
	public void setCorps(String corps) {
		this.corps = corps;
	}
	public Date getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
	public boolean isLu() {
		return lu;
	}
	public void setLu(boolean lu) {
		this.lu = lu;
	}
	
	

}
