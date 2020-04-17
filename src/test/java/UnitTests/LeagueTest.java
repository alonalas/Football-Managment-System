package UnitTests;

import DataLayer.IDataManager;
import DataLayer.dataManager;
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


    private League league ;


    @Before
    public void init(){
        DataComp.setDataManager(new dataManager());
        league = new League(League.LeagueType.LEAGUE_B);
    }

    /**
     * id : U@11
     */
    @Test
    public void checkIfLeagueExist() {
        assertNull( League.checkIfLeagueExist(League.LeagueType.LEAGUE_A)  );
        assertTrue( league.equals(League.checkIfLeagueExist(League.LeagueType.LEAGUE_B) ) );
        assertTrue(null == League.checkIfLeagueExist(League.LeagueType.LEAGUE_A) );
    }

    /**
     * id : U@12
     */
   @Test
    public void showAllLeagues() {
        List<League> leagues = League.ShowAllLeagues();
        assertEquals(1 , leagues.size());
        assertEquals(League.LeagueType.LEAGUE_B , leagues.get(0).getType());
    }
    /**
     * id : U@
     */
    @Test
    public void addLeagues() {
        try {
            List<League> leagues = League.ShowAllLeagues();
            assertEquals(1, leagues.size());
            assertTrue(League.addLeague(League.LeagueType.MAJOR_LEAGUE));
            assertEquals(2, leagues.size());
        }catch (Exception e){}
    }
}