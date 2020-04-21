package IntegrationTests;

import LogicLayer.Page;
import LogicLayer.Player;
import LogicLayer.User;
import ServiceLayer.Controller;
import ServiceLayer.IController;
import ServiceLayer.PlayerService;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class PlayerIntegrationTests {
    private static Player player;
    private static User user;
    private static PlayerService playerService;
    private static IController system;
    private static Page page;


    @BeforeClass
    public static void init(){
        user = new User("Eitan@gmail.com","1234","Eitan","David");
        player = new Player(user,"striker",null,"Eitan",null,null);
        page = new Page(player);
        player.setPage(page);
        String propertiesPath = "log4j.properties";
        PropertyConfigurator.configure(propertiesPath);
        system = new Controller();
        playerService = new PlayerService(player,system);
    }

    /**
     * checks addUpdate func
     */
    @Test
    public void addUpdateTest(){
        try {
            playerService.addUpdate("yalla");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(page.getUpdates().size()==1);
        assertTrue(page.getUpdates().get(0).equals("yalla"));
    }
}
