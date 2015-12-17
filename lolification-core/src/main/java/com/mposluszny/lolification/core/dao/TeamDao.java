package com.mposluszny.lolification.core.dao;

import java.util.List;

import com.mposluszny.lolification.core.domain.Player;
import com.mposluszny.lolification.core.domain.Team;

public interface TeamDao {
	
	public List<Team> getAllTeams();
	public Team getTeamById (long idTeam);
	public Team getTeamByName (String name);
	public void updateTeam(Team Team);
	public void addTeam(Team team);
	public void deleteTeam(Team team);
	public int count();
	public List<Player> getPlayersForTeam(Team team);
}
