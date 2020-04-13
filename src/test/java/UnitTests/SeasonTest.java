package UnitTests;

import DataLayer.IDataManager;
import DataLayer.dataManager;
import LogicLayer.League;
import LogicLayer.Season;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeasonTest  {


    private IDataManager dm;
    private League league ;
    private League league2 ;
    private Season season ;

    @Before
    public void init(){
        dm =  new dataManager();
        league = new League(League.LeagueType.LEAGUE_B);
        league2 = new League(League.LeagueType.LEAGUE_A);
        season = null ;
    }
    @Test
    public void addSeason() {

        String start = "2020-02-01" ;
        String end = "2020-02-03" ;
        boolean success = false ;

        try {
            season = Season.addSeason(start, end, league);
            assertNotNull(season);
            Season.addSeason(start, end, league);
        }catch (IOException e){
            success = true ;
        }
        assertTrue(success);
        try{
            assertEquals(season , Season.addSeason(start, end, league2));
        }catch (IOException e){

        }
    }

    @Test
    public void showAllSeasons() {

        List<Season> seasons = Season.ShowAllSeasons();
        List<League> leagues = League.ShowAllLeagues();
        assertEquals(2 , leagues.size());
        assertEquals(1 , seasons.size());

    }
}