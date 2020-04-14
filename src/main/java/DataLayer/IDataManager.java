package DataLayer;
import LogicLayer.*;

import java.io.File;
import java.util.List;

public interface IDataManager {


    User getUserByPassword(String userName, String password);
    User getUserByMail(String userName, String password);
    League SearchLeagueByType(League.LeagueType leagueType);
    void addLeague(League league) ;
    void addSeason(Season season) ;
    Season SearchSeason(String start , String End);
    List<League> getLeagueList();
    List<Season> getSeasonList();
    boolean addReferee(Referee referee) ;
    boolean removeReferee(Referee referee) ;
    List<User> getUserList();
    List<Referee> getRefereeList() ;
    void TestReset() ;
}
