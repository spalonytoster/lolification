package com.mposluszny.lolification.core.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mposluszny.lolification.core.domain.Player;
import com.mposluszny.lolification.core.domain.Team;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@Transactional
@Rollback(value = true)
public class DAOTest {
	
	@Autowired
	@Qualifier("teamDao")
	TeamDao teamDao;
	@Autowired
	@Qualifier("playerDao")
	PlayerDao playerDao;
	
	@Test
	public void addPlayerTest() {
		
		int before = playerDao.count();
		playerDao.addPlayer(new Player("Jason", "Tran", "Wildturtle", "ADC",
				new Team("TSM", "NA", "2010-10-10"), false));
		assertEquals(playerDao.count(), before+1);
	}

}
