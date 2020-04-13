package UnitTests;

import DataLayer.IDataManager;
import DataLayer.dataManager;
import LogicLayer.*;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;


public class RefereeTest {


    private IDataManager dm;
    private User user;
    private League league;
    private League league2;
    private Season season;
    private Referee referee;


    @Before
    public void init(){
        DataComp.getInstance().TestReset();
        dm =  new dataManager();
        user = new User("l@gmail.com","1234","dan");
        league = new League(League.LeagueType.LEAGUE_A);
        league2 = new League(League.LeagueType.LEAGUE_B);
        String start = "2020-02-01" ;
        String end = "2020-02-03" ;
        season = null;
        try {
            season = Season.addSeason(start, end, league);
        }catch (Exception e) {
        }
        Referee.MakeUserReferee(user , "good","kobi");
        referee = user.ifUserRoleIncludeReferee();
    }
    /**
     * id: U@13
     */
    @Test
    public void makeUserReferee() {
        assertFalse(Referee.MakeUserReferee(user , "good","kobi"));
        assertTrue(user.getRoles().size()==1) ;
    }
    /**
     * id: U@14
     */
    @Test
    public void removeUserReferee() {
        assertTrue(Referee.RemoveUserReferee(referee));
        assertTrue(user.getRoles().size()==0) ;
        assertFalse(Referee.RemoveUserReferee(referee));
        assertTrue(user.getRoles().size()==0) ;
    }
    /**
     * id: U@15
     */
    @Test
    public void addJudgmentApproval() {
        assertTrue(referee.addJudgmentApproval(new Pair<>(league,season)));
        assertFalse(referee.addJudgmentApproval(new Pair<>(league,season)));
    }
    /**
     * id: U@16
     */
    @Test
    public void removeJudgmentApproval() {
        assertTrue(referee.addJudgmentApproval(new Pair<>(league,season)));
        assertTrue(referee.removeJudgmentApproval(new Pair<>(league,season)));
        assertFalse(referee.removeJudgmentApproval(new Pair<>(league,season)));
    }
    /**
     * id: U@17
     */
    @Test
    public void getJudgmentApproval() {
        referee.addJudgmentApproval(new Pair<>(league2,season));
        referee.addJudgmentApproval(new Pair<>(league,season));
        assertTrue(user.ifUserRoleIncludeReferee().getJudgmentApproval().size()==2);
    }
}