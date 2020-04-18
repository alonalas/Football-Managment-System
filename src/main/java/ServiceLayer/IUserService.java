package ServiceLayer;
import LogicLayer.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface IUserService {

    void addPage(Page newPage) throws IOException;
    List<User> getSystemUsers() ;

    void addPages(List<Page> newPages) throws IOException;

    void logOut() throws IOException;

    void showPersonalInformation() throws IOException;

    void editPersonalInformation(String firstName, String lastName, String email) throws IOException;

    void retrieveHistory(Criteria criteria) throws IOException;

    void searchInformation(Criteria criteria, String query) throws IOException;

    void report(String description) throws IOException;

    void addUpdate(String update) throws IOException;

    void addSeason(Date start , Date end , League league ) throws IOException;

    void closeTeam(Team team) throws IOException ;

    void showComplaints()throws IOException;

    void commentComplaint(Complaint complaint,String comment)throws IOException ;

    boolean removeRefereeFromUsers(User user , String qualification , String name) throws IOException;

    boolean RemoveNewRefereeFromUsers(User user) throws IOException;

    String setLeague(League.LeagueType leagueType) throws IOException;

    List<League> showAllLeagus() throws IOException;

    List<Season> showAllSeasons() throws IOException;

    void createGameReport(Game game, String description)throws IOException;

    void addGameEventAfterGame(Game game,String description, String eventType) throws IOException;

    void addGameEvent(Game game ,String description, String eventType) throws IOException;

    String [] displayGames()throws IOException;

    void changeDetails(String newName, String newCualif)throws IOException;

    String showDetails() throws IOException;
}
