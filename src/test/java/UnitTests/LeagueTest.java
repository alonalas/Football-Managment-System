package UnitTests;

import DataLayer.IDataManager;
import LogicLayer.DataComp;
import LogicLayer.League;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LeagueTest  {


    private IDataManager dm;
    private League league ;


    @Before
    public void init(){
        dm =  DataComp.getInstance();

    }
    @Test
    public void checkIfLeagueExist() {
        assertNull( League.checkIfLeagueExist(League.LeagueType.LEAGUE_B)  );
        league = new League(League.LeagueType.LEAGUE_B);
        assertTrue( league.equals(League.checkIfLeagueExist(League.LeagueType.LEAGUE_B) ) );
        assertTrue(null == League.checkIfLeagueExist(League.LeagueType.LEAGUE_A) );
    }

    @Test
    public void showAllLeagues() {
        List<League> leagues = League.ShowAllLeagues();
        assertEquals(1 , leagues.size());
        assertEquals(League.LeagueType.LEAGUE_B , leagues.get(0).getType());
    }

}