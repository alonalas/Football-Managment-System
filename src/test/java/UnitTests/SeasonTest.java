package UnitTests;

import DataLayer.IDataManager;
import LogicLayer.DataComp;
import LogicLayer.Date;
import LogicLayer.League;
import LogicLayer.Season;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.time.LocalDate;

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
        dm =  DataComp.getInstance();
        league = new League(League.LeagueType.LEAGUE_B);
        league2 = new League(League.LeagueType.LEAGUE_A);
        season = null ;
    }
    @Test
    public void addSeason() {

        Date start = new Date(2000, 2 , 24) ;
        Date end = new Date(2000, 2 , 25) ;
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