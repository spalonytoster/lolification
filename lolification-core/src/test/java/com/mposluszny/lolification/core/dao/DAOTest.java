package com.mposluszny.lolification.core.dao;

import static org.junit.Assert.*;

import org.hsqldb.Server;
import org.hsqldb.lib.FileUtil;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerConfiguration;
import org.hsqldb.server.ServerConstants;
import com.mposluszny.lolification.config.ServerProperties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
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
	TeamDao teamDao;
	@Autowired
	PlayerDao playerDao;
	
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
        System.out.println("holder");
	}
	
	@Test
	public void addPlayerTest() {
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
	public void updatePlayerTest() {
		
		
	}
	

}
