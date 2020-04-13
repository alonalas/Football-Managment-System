package UnitTests;

import DataLayer.IDataManager;
import DataLayer.dataManager;
import LogicLayer.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RefereeTest  {


    private IDataManager dm;
    private User user;
    private Game game1;
    private Game game2;
    private Referee refereeA;
    private Referee refereeB;

    @Before
    public void init(){
        dm =  new dataManager();
        user = new User("@","d","d");
        game1 = new Game(null,null,null,null,null,"2020-04-13","12:00","20:00");
        game2 = new Game(null,null,null,null,null,"2020-04-13","15:00","20:00");
        refereeA = new Referee(user,"main","yossi",null);
        refereeB = new Referee(user,"main","haim",null);

    }

    @Test
    public void makeUserReferee() {
        assertTrue(Referee.MakeUserReferee(user , "good","kobi"));
        assertFalse(Referee.MakeUserReferee(user , "good","kobi"));
        assertTrue(user.getRoles().size()==1) ;
    }

    @Test
    public void removeUserReferee() {
        Referee.MakeUserReferee(user , "good","kobi");
        Referee referee =  user.ifUserRoleIncludeReferee() ;
        assertTrue(Referee.RemoveUserReferee(referee));
        assertTrue(user.getRoles().size()==0) ;
        assertFalse(Referee.RemoveUserReferee(referee));
        assertTrue(user.getRoles().size()==0) ;
    }

    // this two tests are for testing two mwthods that we need in the following tests
    @Test
    public void addAGameMain(){
        refereeA.addAGameMain(game1);
        assertTrue(refereeA.getMain().size()==1);
        assertTrue(refereeA.getLine().size()==0);
        assertFalse(refereeA.getLine().size()>0);
    }

    @Test
    public void addGameLine(){
        refereeA.addAGameLine(game1);
        assertTrue(refereeA.getLine().size()==1);
        assertTrue(refereeA.getMain().size()==0);
        assertFalse(refereeA.getMain().size()>0);
    }

    // for UC 10.2
    @Test
    public void displayGames(){
        refereeA.addAGameLine(game1);
        refereeA.addAGameMain(game2);
        String[] list = refereeA.displayGames();
        assertTrue(list.length==4); // two games + 2 for headlines
//        for(int i=0; i<list.length;i++){
//            System.out.println(list[i]);
//        }
    }

    //// for the next two tests you have to set the correct date and time of the games to test it correctly

    //Uc 10.3
    @Test
    public void addGameEvent(){
        refereeA.addAGameLine(game1);
        game1.setMain(refereeA);
        game1.setLine(refereeA);
        refereeA.addGameEvent(game1,"good game","offside");
        refereeA.addGameEvent(game1,"good","offset"); // no such type
        refereeB.addGameEvent(game1,"hh","offside"); // no the referee in the game
      //  assertTrue(game1.getGameEventCalender().size()==1);

        game2.setLine(refereeA);
        game2.setLine(refereeB);
        refereeB.addAGameLine(game2);
        refereeB.addGameEvent(game2,"ss","dd");// the game is not taking place, notice the date when tou test it

    }



    // UC 10.4
    @Test
    public void addEventAfterGame(){
        refereeA.addAGameMain(game2);
        game2.setMain(refereeA);
        refereeA.addEventAfterGame(game2,"ss","offside");

        game1.setMain(refereeA);
        game1.setLine(refereeB);
        refereeA.addAGameMain(game1);
        refereeA.addEventAfterGame(game1,"cc","offside");
        //assertTrue(game1.getGameEventCalender().size()==1);
        refereeA.addEventAfterGame(game1,"cc","offsidea"); // no such type of event
        refereeB.addAGameLine(game1);
        refereeB.addEventAfterGame(game1,"aa","offside"); // not the main referee
    }

    @Test
    public void createGameReport(){
        game1.setLine(refereeB);
        game1.setMain(refereeA);
        refereeA.addAGameMain(game1);
        refereeB.addAGameLine(game2);

        refereeA.createGameReport(game1,"best game everrrr");
        refereeB.createGameReport(game1,"bbb");
        game1.getGameReport().displayReport();
    }
}