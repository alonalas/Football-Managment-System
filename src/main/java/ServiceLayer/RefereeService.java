package ServiceLayer;

import LogicLayer.Game;
import LogicLayer.GameEventCalender;
import LogicLayer.GameReport;
import LogicLayer.Referee;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class RefereeService extends AUserService {
    private Referee referee;
    private static final Logger testLogger = Logger.getLogger(RefereeService.class);


    public RefereeService(Referee referee) {
        this.referee = referee;
    }

    /**
     * ID: Referee@1
     * UC 10.1
     * ID: @RefereeService1
     * display the Referee's details
     */
    @Override
    public String showDetails(){
        System.out.println("Name of referee: " + referee.getName());
        System.out.println("Qualification: " + referee.getQualification());
        // for gui
        return ("Name of referee: " + referee.getName() + "\n Qualification: " + referee.getQualification());
    }

    public Referee getReferee() {
        return referee;
    }

    /**
     * ID: Referee@2
     * UC 10.1
     * ID: @RefereeService2
     * change the details of the referee
     * @param newName - the new name we want to save for the referee
     * @param newCualif - the new qualification for the referee
     * @throws IOException
     */
    @Override
    public void changeDetails(String newName, String newCualif) throws IOException {
        referee.setName(newName);
        referee.setQualification(newCualif);
    }


    /**
     * ID: Referee@3
     * UC 10.2
     * ID: @RefereeService3
     * displays the referee's games
     * @throws IOException
     */
    @Override
    public String[] displayGames() throws IOException {
        return referee.displayGames();
    }


    /**
     * UC 10.3
     * ID: RefereeService@4
     * adds a new gameEvnet to the system while the game is active
     * @param game - the game we want to add an event for
     * @param description - the description of the event
     * @param eventType - event type (enum)
     * @throws IOException
     */
    @Override
    public void addGameEvent(Game game,String description, String eventType) throws IOException {
        referee.addGameEvent(game,description,eventType);
    }


    /**
     * UC 10.4.1
     * ID: RefereeService@5
     * adds a new game event to the system after the game ended by a main referee
     * @param game - the game we want to add an event for
     * @param description - the description of the event
     * @param eventType - event type (enum)
     * @throws IOException
     */
    @Override
    public void addGameEventAfterGame(Game game,String description, String eventType) throws IOException {
        referee.addEventAfterGame(game,description,eventType);
    }


    /**
     * UC 10.4.2
     * ID: RefereeService@6
     * creates game report for a specific game by main referee
     * @param game - the game we want to create a report for
     * @param description - description of the report
     * @throws IOException
     */
    @Override
    public void createGameReport(Game game, String description)throws IOException {
      referee.createGameReport(game,description);
    }
}
