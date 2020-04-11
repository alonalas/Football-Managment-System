import LogicLayer.*;
import ServiceLayer.RefereeService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RefereeServiceTest {
    // Tester
    private static RefereeService refereeService;
    private static Game game1;
    // Logger
    private static final Logger testLogger = Logger.getLogger(RefereeService.class);

    // This Function Run Before All LogicLayer.Administrator Tests
    @BeforeClass
    public static void init(){
        // Init LogicLayer.Administrator Tester
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy");
        String date1= "2020-01-01";
        String date2= "2021-01-01";
        try {
            Date dateS= simpleDateFormat.parse(date1);
            Date dateE= simpleDateFormat.parse(date2);

            refereeService = new RefereeService(
                new Referee(new User("enmail@","123","test",null,null),"stam",
                        "rif",null)
        );
        game1 = new Game(new Season(null,dateS,dateE,null,null,null),
                new Team("stadium1",null,null,null,null,null,null,null,null),
                new Team("stadium1",null,null,null,null,null,null,null,null),refereeService.getReferee(),null,
                "2020-04-11","15:30","20:00");
        String propertiesPath = "log4j.properties";
        PropertyConfigurator.configure(propertiesPath);
        testLogger.info("Start Testing: AdministratorTests");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void showDetails(){
        testLogger.info("Run: showDetails");
        refereeService.showDetails();
        testLogger.info("Ended: testPasswordContent");
    }

    @Test
    public void changeDetails() throws IOException {
        refereeService.showDetails();
        refereeService.changeDetails("Yossi","main");
        refereeService.showDetails();
    }
    @Test
    public void displayGames(){

            refereeService.getReferee().addAGameLine(game1);
        try {
            refereeService.displayGames();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
     @Test
     public void addGameEvent(){
         try {
             refereeService.getReferee().addAGameLine(game1);
             // notice to change the date and time of the game according to the test time
             // otherwise it will fail
             refereeService.addGameEvent(game1,"bad","offense");
             for (Game game :refereeService.getReferee().getLine()){
                 for(GameEventCalender event : game.getGameEventCalender()){
                     event.displayEvents();
                 }

             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }



     @Test
     public void addGameEventAfterGame() throws IOException {
        refereeService.getReferee().addAGameMain(game1);
        game1.setMain(refereeService.getReferee());
        refereeService.addGameEventAfterGame(game1,"best game ever", "offside");
         for (Game game :refereeService.getReferee().getMain()){
             for(GameEventCalender event : game.getGameEventCalender()){
                 event.displayEvents();
             }

         }

     }

     @Test
     public void createGameReport(){
         refereeService.getReferee().addAGameLine(game1);
         game1.setLine(refereeService.getReferee());
         try {
             refereeService.createGameReport(game1,"baddddd game ever");
             game1.getGameReport().displayReport();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }


    @AfterClass
    public static void close(){
        testLogger.info("All Tests Completed");
    }
}
