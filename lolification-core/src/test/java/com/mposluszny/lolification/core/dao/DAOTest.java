package com.mposluszny.lolification.core.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.hibernate.SessionFactory;
import org.hsqldb.Server;
import org.hsqldb.lib.FileUtil;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerConfiguration;
import org.hsqldb.server.ServerConstants;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mposluszny.lolification.config.ServerProperties;
import com.mposluszny.lolification.core.domain.Player;
import com.mposluszny.lolification.core.domain.Team;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@Transactional
@Rollback(value = true)
public class DAOTest {
	
	@Autowired
	TeamDao teamDao;
	@Autowired
	PlayerDao playerDao;
	@Autowired
	SessionFactory sessionFactory;
	
	@BeforeClass
	public static void startupHSQLDB() {
		
		final String DB_NAME = "lolificationdb";
		String[] args = { "--database.0" ,"mem:mydb", "--dbname.0", DB_NAME };
		HsqlProperties argProps = null;

        argProps = HsqlProperties.argArrayToProps(args,
                ServerProperties.sc_key_prefix);

        String[] errors = argProps.getErrorKeys();

        if (errors.length != 0) {
            System.out.println("no value for argument:" + errors[0]);

            return;
        }

        String propsPath = argProps.getProperty(ServerProperties.sc_key_props);
        String propsExtension = "";

        if (propsPath == null) {
            propsPath      = "server";
            propsExtension = ".properties";
        } else {
            argProps.removeProperty(ServerProperties.sc_key_props);
        }

        propsPath = FileUtil.getFileUtil().canonicalOrAbsolutePath(propsPath);

        ServerProperties props = new ServerProperties(ServerConstants.SC_PROTOCOL_HSQL);

        props.addProperties(argProps);
        ServerConfiguration.translateDefaultDatabaseProperty(props);

        ServerConfiguration.translateDefaultNoSystemExitProperty(props);
        ServerConfiguration.translateAddressProperty(props);

        // finished setting up properties;
        Server server = new Server();

        try {
            server.setProperties(props);
        } catch (Exception e) {
            System.out.println("Failed to set properties");
            e.printStackTrace();

            return;
        }

        server.start();
	}
	
	@Test
	public void TestGetAll() {
		assertNotNull(teamDao.getAllTeams());
		assertTrue(teamDao.getAllTeams().size() == teamDao.count());
		assertTrue(playerDao.getAllPlayers().size() == playerDao.count());
	}
	
	@Test
	public void addTest() {
		
		final String IGN = "Wildturtle";
		
		int before = playerDao.count();
		playerDao.addPlayer(new Player("Jason", "Tran", "Wildturtle", "ADC",
				new Team("TSM", "NA", "2010-10-10"), false));
		int after = playerDao.count();
		assertEquals(after, before+1);
		
		Player player = playerDao.getPlayerByIgn(IGN);
		assertNotNull(player);
		
		assertNotNull(player.getTeam());
		assertNotNull(teamDao.getTeamById(player.getTeam().getIdTeam()));
	}
	
	@Test
	public void updateTest() {

		Team team = new Team("Roccat", "EU", "2011-10-10");
		teamDao.addTeam(team);
		team = teamDao.getTeamByName("Roccat");
		final String NEW_NAME = "Kiedys Mialem Team";
		team.setName(NEW_NAME);
		teamDao.updateTeam(team);
		Team team2 = teamDao.getTeamByName(NEW_NAME);
		assertEquals(team.getIdTeam(), team2.getIdTeam());
		
		Player player = new Player("Marcin", "Jankowski", "Jankos", "Jungle", team2, false);
		playerDao.addPlayer(player);
		player = playerDao.getPlayerByIgn("Jankos");
		assertFalse(player.isRetired());
		player.setRetired(true);
		playerDao.updatePlayer(player);
		Player player2 = playerDao.getPlayerByIgn("Jankos");
		assertTrue(player2.isRetired());
	}
	
	@Test
	public void deleteTest() {
		Player player1 = new Player("Macrcus", "Hill", "Dyrus", "TOP", "TSM", true);
		Player player2 = new Player("Fabian", "Diepstraten", "Febiven", "MID", "Fnatic", false);
		Team team = new Team("CLG", "NA", "2010-09-25");
		
		playerDao.addPlayer(player1); playerDao.addPlayer(player2);
		teamDao.addTeam(team);
		
		player1 = playerDao.getPlayerByIgn(player1.getIgn());
		player2 = playerDao.getPlayerByIgn(player2.getIgn());
		team = teamDao.getTeamByName("CLG");
		
		int playerCountBefore = playerDao.count();
		int teamCountBefore = teamDao.count();
		
		playerDao.deletePlayer(player1);
		playerDao.deletePlayer(player2);
		teamDao.deleteTeam(team);
		
		int playerCountAfter = playerDao.count();
		int teamCountAfter= teamDao.count();
		
		assertTrue(playerCountBefore == playerCountAfter+2);
		assertTrue(teamCountBefore == teamCountAfter+1);
	}
	
	@Test
	public void testRelation() {
		// TODO napisać test
//		Team team = teamDao.getTeamByName("Fnatic");
//		team.setPlayers(teamDao.getPlayersForTeam(team));
//		
//		for (Player player : team.getPlayers()) {
//			
//			assertTrue(player.getTeam().getIdTeam() == team.getIdTeam());
//		}
	}
	
	@Test
	public void transferPlayerTest() {
		
		//TODO napisać test
	}
	

}
