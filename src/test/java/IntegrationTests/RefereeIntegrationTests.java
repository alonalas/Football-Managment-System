package IntegrationTests;

import DataLayer.dataManager;
import LogicLayer.*;
import ServiceLayer.RefereeService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RefereeIntegrationTests {
    private User user;
    private Game game1;
    private Game game2;
    private Referee refereeA;
    private Referee refereeB;
    private RefereeService refereeService1;
    private RefereeService refereeService2;


    @Before
    public void init(){
        user = new User("@","d","d");
        game1 = new Game(null,null,null,null,null,"2020-04-13","12:00","10:00");
        game2 = new Game(null,null,null,null,null,"2020-04-13","15:00","20:00");
        refereeA = new Referee(user,"main","yossi",null);
        refereeB = new Referee(user,"main","haim",null);
        refereeService1= new RefereeService(refereeA);
        refereeService2=new RefereeService(refereeB);
    }

    @Test
    public void showDetails(){
        System.out.println(refereeService1.showDetails());
        System.out.println(refereeService2.showDetails());
    }

    @Test
    public void changeDetails(){
        try {
            refereeService1.showDetails();
            refereeService1.changeDetails("chen","aa");
            refereeService1.showDetails();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void displayGames(){
        refereeService1.getReferee().addAGameMain(game1);
        refereeService1.getReferee().addAGameMain(game2);
        try {
            refereeService1.displayGames();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // for the next two tests you must change the games time and date for a present game to check it
    @Test
    public void addGameEvent() throws IOException {
        game1.setMain(refereeService1.getReferee());
        game1.setLine(refereeService2.getReferee());
        game2.setLine(refereeService1.getReferee());
        game2.setMain(refereeService2.getReferee());
        refereeService1.getReferee().addAGameMain(game1);
        refereeService1.getReferee().addAGameLine(game2);

        refereeService1.addGameEvent(game1,"cc","offside"); // game ended
        refereeService1.addGameEvent(game2,"dd","dd");// no type
        refereeService2.addGameEvent(game2,"ee","offside");

    }



    @Test
    public void addEvntAfterGame(){
        game1.setMain(refereeService1.getReferee());
        game1.setLine(refereeService2.getReferee());
        game2.setLine(refereeService1.getReferee());
        game2.setMain(refereeService2.getReferee());
        refereeService1.getReferee().addAGameMain(game1);
        refereeService1.getReferee().addAGameLine(game2);

        try {
            refereeService1.addGameEventAfterGame(game1,"ff","dd"); // not a type
            refereeService1.addGameEventAfterGame(game1,"ff","offside");
            refereeService2.addGameEventAfterGame(game1,"ee","offside"); // not the main

            refereeService2.addGameEventAfterGame(game2,"ss","offside"); //
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void createGameReport(){
        game1.setMain(refereeService1.getReferee());
        game1.setLine(refereeService2.getReferee());
        refereeService1.getReferee().addAGameMain(game1);
        refereeService2.getReferee().addAGameLine(game1);

        try {
            refereeService1.createGameReport(game1,"good");
            game1.getGameReport().displayReport();

            refereeService2.createGameReport(game1,"bad"); // not the main referee
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
