package ServiceLayer;

import LogicLayer.League;
import LogicLayer.Game;
import LogicLayer.Page;
import LogicLayer.Season;
import LogicLayer.User;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public abstract class AUserService implements IUserService{

    Controller control;

    public AUserService(){}
    public AUserService(Controller control) {
        this.control = control;
    }



    public void addPage(Page newPage) throws IOException {
        throw new IOException("not possible");
    }


    public String showDetails() throws IOException {
        throw new IOException("No details to be shown");
    }

    public void changeDetails(String newName, String newCualif)throws IOException{
        throw new IOException("No details to be changed");
    }

    public String [] displayGames()throws IOException{
        throw new IOException("no games");
    }

    public void addGameEvent(Game game ,String description, String eventType) throws IOException{
        throw new IOException("no games");
    }

    public void addGameEventAfterGame(Game game,String description, String eventType) throws IOException {
        throw new IOException("no games");
    }

    public void createGameReport(Game game, String description)throws IOException {
        throw new IOException("no games");
    }
    public String setLeague(League.LeagueType leagueType) throws IOException{
        throw new IOException("Unsupported method");
    }
    public List<League> showAllLeagus() throws IOException{
        throw new IOException("Unsupported method");
    }
    public void addSeason(Date start , Date end , League league ) throws IOException{
        throw new IOException("Unsupported method");
    }
    public List<Season> ShowAllSeasons() throws IOException{
        throw new IOException("Unsupported method");
    }
    boolean addNewRefereeFromUsers(User user , String qualification , String name) throws IOException{
        throw new IOException("Unsupported method");
    }
    public boolean RemoveNewRefereeFromUsers(User user) throws IOException{
        throw new IOException("Unsupported method");
    }
}
