package com.mposluszny.lolification.core.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "player.all", query = "SELECT p FROM Player p"),
	@NamedQuery(name = "player.byIgn", query = "SELECT p FROM Player p WHERE p.ign = :ign")
})
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPlayer;
	private String name;
	private String surname;
	private String ign;
	private String role;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Team team;
	private boolean isRetired;
	
	public Player() {
		
	}
	
	public long getIdPlayer() {
		return idPlayer;
	}
	
	public void setIdPlayer(long idPlayer) {
		this.idPlayer = idPlayer;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getIgn() {
		return ign;
	}
	
	public void setIgn(String ign) {
		this.ign = ign;
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isRetired() {
		return isRetired;
	}
	
	public void setRetired(boolean isRetired) {
		this.isRetired = isRetired;
	}

}
