package com.mposluszny.lolification.core.dao;

import java.util.List;

import com.mposluszny.lolification.core.domain.Player;

public interface PlayerDao {

	public List<Player> getAllPlayers();
	public Player getPlayerById(long idPlayer);
	public Player getPlayerByIgn(String ign);
	public void updatePlayer(Player player);
	public void addPlayer(Player player);
	public void deletePlayer(Player player);
	public int count();
	public void transferPlayer(long idPlayer, long idTeam);
}
