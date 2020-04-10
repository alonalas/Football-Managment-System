package ServiceLayer;

import LogicLayer.Game;
import LogicLayer.GameEventCalender;
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

    @Override
    public void showDetails(){
        System.out.println("Name of referee: " + referee.getName());
        System.out.println("Qualification: " + referee.getQualification());
    }


    @Override
    public void changeDetails(String newName, String newCualif) throws IOException {
        referee.setName(newName);
        referee.setQualification(newCualif);
    }

    @Override
    public void displayGames() throws IOException {
        System.out.println("main games:");
        for(Game game : referee.getMain()){
            System.out.println(game.toString());
        }
        System.out.println("line games: ");
        for(Game game : referee.getLine()){
            System.out.println(game.toString());
        }
    }

    @Override
    public void addGameEvent(Game game,String description, String eventType) throws IOException {
        LocalDate date=LocalDate.now();
        LocalTime now=LocalTime.now();
        if(game.getLine().equals(referee) || game.getMain().equals(referee)){
            if(date.compareTo(LocalDate.parse(game.getDate()))==0){
                if(now.isBefore(LocalTime.parse(game.getEndTime()))&& now.isAfter(LocalTime.parse(game.getStartTime()))){
                    GameEventCalender event = new GameEventCalender(game,now.toString(),date.toString(),eventType,description,now.getMinute());
                    game.addEventGame(event);
                    String propertiesPath = "log4j.properties";
                    PropertyConfigurator.configure(propertiesPath);
                    testLogger.info("Added new game event");
                }
            }
        }
    }

    @Override
    public void addGameEventAfterGame(Game game,String description, String eventType) throws IOException {
        LocalDate date=LocalDate.now();
        LocalTime now=LocalTime.now();
        if(game.getMain().equals(referee)){
            if(date.compareTo(LocalDate.parse(game.getDate()))==0){
                if(now.minusHours(5).isBefore(LocalTime.parse(game.getEndTime()))){
                    GameEventCalender event = new GameEventCalender(game,now.toString(),date.toString(),eventType,description,now.getMinute());
                    game.addEventGame(event);
                    String propertiesPath = "log4j.properties";
                    PropertyConfigurator.configure(propertiesPath);
                    testLogger.info("Added new game event");
                }
            }
        }
    }
}
