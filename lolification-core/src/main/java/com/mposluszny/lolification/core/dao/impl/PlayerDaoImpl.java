package com.mposluszny.lolification.core.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mposluszny.lolification.core.dao.PlayerDao;
import com.mposluszny.lolification.core.domain.Player;

@Component
public class PlayerDaoImpl implements PlayerDao {

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
	public List<Player> getAllPlayers() {
		return getSessionFactory().getCurrentSession().getNamedQuery("player.all").list();
	}

	@Override
	public Player getPlayerById(long idPlayer) {
		return (Player) getSessionFactory().getCurrentSession().get(Player.class, idPlayer);
	}

	@Override
	public Player getPlayerByIgn(String ign) {
		return (Player) getSessionFactory().getCurrentSession().getNamedQuery("player.byIgn")
				.setString("ign", ign).uniqueResult();
	}

	@Override
	public void updatePlayer(Player player) {
		getSessionFactory().getCurrentSession().update(player);
	}

	@Override
	public void addPlayer(Player player) {
		getSessionFactory().getCurrentSession().persist(player);
	}

	@Override
	public void deletePlayer(Player player) {
		getSessionFactory().getCurrentSession().delete(player);
	}

	@Override
	public int count() {
		return ((Number) getSessionFactory().getCurrentSession()
				.createCriteria("Player").setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}

}