import DataLayer.IDataManager;
import DataLayer.dataManager;
import LogicLayer.League;
import LogicLayer.Season;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class Read_Write_Object_test {
    @Test
    public void readWrite(){
        IDataManager dataManagerTest = new dataManager() ;
        League league = new League(League.LeagueType.SECOND_LEAGUE) ;
        dataManagerTest.addLeague(league);
        dataManagerTest.addSeason(new Season("2020-02-01","1999-02-02",league ));
        assertTrue(dataManagerTest.getLeagueList().size() == 1);
        File file = new File("testObjectWrite.txt");
        dataManager.writeData(dataManagerTest , file);
        IDataManager data2 = dataManager.readData(file);
        assertTrue(data2.getLeagueList().size() == 1);
        assertTrue(data2.getSeasonList().size() == 1);
    }
}
