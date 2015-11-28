package com.mposluszny.lolification.core.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "team.all", query = "SELECT t FROM Team t"),
	@NamedQuery(name = "team.byName", query = "SELECT t FROM Team t WHERE t.name = :name")
})
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTeam;
	private String name;
	private String region;
	private String dateOfEstablishment;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Player> players;
	
	public Team () {
		
		
	}
	
	public Team (String name, String region, String dateOfEstablishment) {
		
		this.name = name;
		this.region = region;
		this.dateOfEstablishment = dateOfEstablishment;
	}
	
	public long getIdTeam() {
		return idTeam;
	}
	
	public void setIdTeam(long idTeam) {
		this.idTeam = idTeam;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getDateOfEstablishment() {
		return dateOfEstablishment;
	}
	
	public void setDateOfEstablishment(String dateOfEstablishment) {
		this.dateOfEstablishment = dateOfEstablishment;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
