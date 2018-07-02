package jeton.beans;

import java.util.Date;

public class Agenda {
	
	int idAgenda;
	Date dateDebut;
	Date dateFin;
	int reserve;
	String description;
	int idEquipe;
	int idUserIntervenant;
	
	public Agenda(int idAgenda, Date dateDebut, Date dateFin, int reserve, String description,
			int idEquipe, int idUserIntervenant) {
		super();
		this.idAgenda = idAgenda;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.reserve = reserve;
		this.description = description;
		this.idEquipe = idEquipe;
		this.idUserIntervenant = idUserIntervenant;
	}
	
	public int getIdUserIntervenant() {
		return idUserIntervenant;
	}
	public void setIdUserIntervenant(int idUserIntervenant) {
		this.idUserIntervenant = idUserIntervenant;
	}
	public int getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}

	public int getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public int getReserve() {
		return reserve;
	}
	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
