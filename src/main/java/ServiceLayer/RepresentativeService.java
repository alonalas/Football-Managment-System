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
     * @return boolean of success/unsuccessful operation
     * @throws Exception if league type illigel
     */
    public boolean addLeague(League.LeagueType leagueType) throws IOException{
        return League.addLeague(leagueType);
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
    public void addSeason(String start , String end , League league ) throws IOException{
        Season.addSeason(start , end ,league);
    }

    /**
     * id: RepresentativeService@4
     * show all existing Seasons
     * @return all system Seasons
     */
    public List<Season> showAllSeasons() throws IOException{
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
    public boolean removeRefereeFromUsers(User user) throws IOException{
        Referee referee = user.ifUserRoleIncludeReferee();
        if(referee == null){
            return false;
        }
        return Referee.RemoveUserReferee(referee) ;
    }


    /**
     * id: RepresentativeService@7
     * show all system referees
     * @return system referees
     */
    public List<Referee> showAllReferees() throws IOException{
        return Referee.getReferees() ;
    }

    /**
     * id: RepresentativeService@8
     * show all system referees
     * @return true if added successfully
     */
    public boolean addJudgmentApproval(Referee referee , League league, Season season ) throws IOException{
        if(league == null || season == null || referee == null) return false;
        return referee.addJudgmentApproval(new JudgmentApproval(league,season));
    }

    /**
     * id: RepresentativeService@9
     * show all system referees
     * @return true if added successfully
     */
    public boolean removeJudgmentApproval(Referee referee , League league, Season season ) throws IOException{
        if(league == null || season == null || referee == null) return false;
        return referee.removeJudgmentApproval(new JudgmentApproval(league,season));
    }
}
