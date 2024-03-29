package com.mposluszny.lolification.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mposluszny.lolification.core.dao.TeamDao;
import com.mposluszny.lolification.core.domain.Player;
import com.mposluszny.lolification.core.domain.Team;

@Component("teamDao")
@Transactional
public class TeamDaoImpl implements TeamDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Team> getAllTeams() {
		return getSessionFactory().getCurrentSession().getNamedQuery("team.all").list();
	}

	@Override
	public Team getTeamById(long idTeam) {
		return (Team) getSessionFactory().getCurrentSession().get(Team.class, idTeam);
	}

	@Override
	public Team getTeamByName(String name) {
		return (Team) getSessionFactory().getCurrentSession().getNamedQuery("team.byName")
				.setString("name", name).uniqueResult();
	}

	@Override
	public void updateTeam(Team Team) {
		getSessionFactory().getCurrentSession().update(Team);
	}

	@Override
	public void addTeam(Team team) {
		getSessionFactory().getCurrentSession().persist(team);
	}

	@Override
	public void deleteTeam(Team team) {
		team = (Team) getSessionFactory().getCurrentSession()
				.get(Team.class, team.getIdTeam());
		
		if (team.getPlayers() != null) {
			for (Player player : team.getPlayers()) {
				player.setTeam(null);
			}
		}
		
		getSessionFactory().getCurrentSession().delete(team);
	}

	@Override
	public int count() {
		return ((Number) getSessionFactory().getCurrentSession()
				.createCriteria(Team.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}

	@Override
	public List<Player> getPlayersForTeam(Team team) {
		team = (Team) getSessionFactory().getCurrentSession()
				.get(Team.class, team.getIdTeam());
		
		List<Player> players = new ArrayList<Player>(team.getPlayers());
		return players;
	}

}
