package com.mposluszny.lolification.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPlayer;
	private String name;
	private String surname;
	@Column(unique = true)
	private String ign;
	private String role;
	private Team team;
	private boolean isRetired;
	
	public Player() {
		
		
	}
	
	public Player(String name, String surname, String ign, String role, Team team, boolean isRetired) {
		
		this.name = name;
		this.surname = surname;
		this.ign = ign;
		this.setRole(role);
		this.team = team;
		this.isRetired = isRetired;
	}
	
	public Player(String name, String surname, String ign, String role, long idTeam, boolean isRetired) {
		
		this.name = name;
		this.surname = surname;
		this.ign = ign;
		this.setRole(role);
		this.team = new Team();
		this.team.setIdTeam(idTeam);
		this.isRetired = isRetired;
	}
	
	public Player(String name, String surname, String ign, String role, String teamName, boolean isRetired) {
		
		this.name = name;
		this.surname = surname;
		this.ign = ign;
		this.role = role;
		this.team = new Team();
		this.team.setName(teamName);
		this.isRetired = isRetired;
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
