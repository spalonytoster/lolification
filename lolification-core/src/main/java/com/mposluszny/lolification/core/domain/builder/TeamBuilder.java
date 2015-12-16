package com.mposluszny.lolification.core.domain.builder;

import java.util.List;

import com.mposluszny.lolification.core.domain.Player;
import com.mposluszny.lolification.core.domain.Team;

  /**
	*private long idTeam;
	*private String name;
	*private String region;
	*private String dateOfEstablishment;
	*private List<Player> players;
	*
    */

public class TeamBuilder {
	
	private Team team = new Team();
	
	public TeamBuilder idTeam(long idTeam) {
		team.setIdTeam(idTeam);
		return this;
	}
	
	public TeamBuilder name(String name) {
		team.setName(name);
		return this;
	}
	
	public TeamBuilder region(String region) {
		team.setRegion(region);
		return this;
	}
	
	public TeamBuilder dateOfEstablishment(String dateOfEstablishment) {
		team.setDateOfEstablishment(dateOfEstablishment);;
		return this;
	}
	
	public TeamBuilder players(List<Player> players) {
		team.setPlayers(players);
		return this;
	}
	
	public Team build() {
		return team;
	}
}
