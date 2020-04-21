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
import java.util.List;

public abstract class AUserService implements IUserService{

    Controller control;

    public AUserService(){}
    public AUserService(Controller control) {
        this.control = control;
    }

    /**
     * Id: AUserService@1
     * @return system users
     */
    public List<User> getSystemUsers(){
        return User.getAllUsers();
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
    public List<Season> showAllSeasons() throws IOException{
        throw new IOException("Unsupported method");
    }
    boolean removeRefereeFromUsers(User user , String qualification , String name) throws IOException{
        throw new IOException("Unsupported method");
    }
    public boolean RemoveNewRefereeFromUsers(User user) throws IOException {
        throw new IOException("Unsupported method");
    }

    public void addPages(List<Page> newPages) throws IOException {
        throw new IOException("not possible");
    }

    public void logOut() throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public List<String> showPersonalInformation() throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public boolean editPersonalInformation(String firstName, String lastName, String email) throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public List<String> retrieveHistory(Criteria criteria) throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public void searchInformation(Criteria criteria, String query) throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public void report(String description) throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public void addUpdate(String update) throws IOException {
        throw new IOException("not possible");
    }
}
