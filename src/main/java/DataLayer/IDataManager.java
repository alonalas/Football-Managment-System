package DataLayer;
import LogicLayer.*;

import java.util.Date;
import java.util.List;

public interface IDataManager {

    User getUser(String userName, String password);
    League SearchLeagueByType(League.LeagueType leagueType);
    void addLeague(League league) ;
    void addSeason(Season season) ;
    Season SearchSeason(Date start , Date End);
    List<League> getLeagueList();
    List<Season> getSeasonList();
    boolean addReferee(Referee referee) ;
    boolean removeReferee(Referee referee) ;
}
