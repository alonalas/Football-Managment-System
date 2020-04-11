package ServiceLayer;

import LogicLayer.*;

import java.io.IOException;
import java.util.List;

public class RepresentativeService extends AUserService {

    public RepresentativeService(Controller control) {
        super(control);
    }

    /**
     * id: RepresentativeService@1
     * add new League
     * @param leagueType
     * @return string of success/unsuccessful operation
     * @throws Exception if league type illigel
     */
    public String setLeague(League.LeagueType leagueType) throws IOException{
        if(leagueType==null){
            throw new IOException("illigeal league type");
        }
        League league= League.checkIfLeagueExist(leagueType);
        if(league != null){
            return "League already Exist!";
        }
        new League(leagueType);
        return "League been added successfully";
    }

    /**
     * id: RepresentativeService@2
     * @return show all Leagues that existing in the system
     */
    public List<League> showAllLeagus() throws IOException{
        return League.ShowAllLeagues();
    }

    /**
     * id: RepresentativeService@3
     * can add new season -or- if season existing addes a league to it
     * @param start date of season
     * @param end date of season
     * @param league to link the season to League
     * @throws IOException if season already exists
     */
    public void addSeason(Date start , Date end , League league ) throws IOException{
        Season.addSeason(start , end ,league);
    }

    /**
     * id: RepresentativeService@4
     * show all existing Seasons
     * @return all system Seasons
     */
    public List<Season> ShowAllSeasons() throws IOException{
       return Season.ShowAllSeasons();
    }

    /**
     * id: RepresentativeService@5
     * add new referee from exist users
     * @return true if added successfully, else if already exists
     */
    public boolean addNewRefereeFromUsers(User user , String qualification , String name) throws IOException{
        return Referee.MakeUserReferee( user,  qualification,  name) ;
    }

    /**
     * id: RepresentativeService@6
     * add new referee from exist users
     * @return true if added successfully, else if already exists
     */
    public boolean RemoveNewRefereeFromUsers(User user) throws IOException{
        Referee referee = user.ifUserRoleIncludeReferee();
        if(referee == null){
            return false;
        }
        return Referee.RemoveUserReferee(referee) ;
    }
}
