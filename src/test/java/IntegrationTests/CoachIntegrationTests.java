package IntegrationTests;

import LogicLayer.Coach;
import LogicLayer.Page;
import LogicLayer.Player;
import LogicLayer.User;
import ServiceLayer.CoachService;
import ServiceLayer.Controller;
import ServiceLayer.IController;
import ServiceLayer.PlayerService;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CoachIntegrationTests {
    private static Coach coach;
    private static User user;
    private static CoachService coachService;
    private static IController system;
    private static Page page;


    @BeforeClass
    public static void init(){
        user = new User("Eitan@gmail.com","1234","Eitan","David");
        coach = new Coach(user,"Eitan",null,"Eitan",null,null);
        page = new Page(coach);
        coach.setPage(page);
        String propertiesPath = "log4j.properties";
        PropertyConfigurator.configure(propertiesPath);
        system = new Controller();
        coachService = new CoachService(coach,system);
    }

    /**
     * checks addUpdate func
     */
    @Test
    public void addUpdateTest(){

        try {
            coachService.addUpdate("yalla");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(page.getUpdates().size()==1);
        assertTrue(page.getUpdates().get(0).equals("yalla"));
    }

}
