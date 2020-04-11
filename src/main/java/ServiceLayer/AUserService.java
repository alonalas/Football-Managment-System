package ServiceLayer;

import LogicLayer.League;
import LogicLayer.Page;
import LogicLayer.Season;
import LogicLayer.User;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public abstract class AUserService implements IUserService{

    Controller control;

    public AUserService(Controller control) {
        this.control = control;
    }



    public void addPage(Page newPage) throws IOException {
        throw new IOException("Eitan");
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
