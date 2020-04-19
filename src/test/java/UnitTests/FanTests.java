package UnitTests;

import DataLayer.IDataManager;
import DataLayer.dataManager;
import LogicLayer.*;
import ServiceLayer.Criteria;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.crypto.Data;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class FanTests {
    private static final Logger testLogger = Logger.getLogger(GuestTests.class);
    private static Fan fan;
    private static User user;


    @BeforeClass
    public static void init(){
        user = new User("Eitan@gmail.com","1234","Eitan","David");
        fan = new Fan(user,user.getFirstName());
        String propertiesPath = "log4j.properties";
        PropertyConfigurator.configure(propertiesPath);
    }

    @Before
    public void setUp() throws Exception {
        DataComp.setDataManager(new dataManager());
    }


    /**
     * checks addPages func
     */
    @Test
    public void addPagesTest(){
        testLogger.info("Run: addPagesTest");
        //checks if page added
        List<Page>pages = new ArrayList<>();
        Page testPage1 = new Page(new Player(user," ",null," ", "2001-01-01"));
        pages.add(testPage1);
        fan.addPages(pages);
        assertTrue(fan.getPages().size() == 1);
        //checks if right page added
        testPage1.addUpdate("Eitan");
        assertEquals("Eitan",testPage1.getUpdates().get(0));
        testLogger.info("Ended: addPagesTest");
    }

    /**
     * checks addSearchHistoryFunc
     */
    @Test
    public void addSearchHistoryTest(){
        //checks adding to search for name history
        Criteria criteria = Criteria.Name;
        String query = "Eitan";
        fan.addSearchHistory(criteria, query);
        assertTrue(DataComp.getInstance().getFanSearchNameHistory().size() == 1);
        //checks adding to search for KeyWord history
        criteria = Criteria.KeyWord;
        fan.addSearchHistory(criteria,query);
        assertTrue(DataComp.getInstance().getFanSearchKeyWordHistory().size() == 1);
        //checks adding to search for Category history
        criteria = Criteria.Category;
        fan.addSearchHistory(criteria,query);
        assertTrue(DataComp.getInstance().getFanSearchCategoryHistory().size() == 1);
    }

    /**
     * checks getSearchHistory func
     */
    @Test
    public void retrieveSearchHistoryTest(){
        List<String>testSearch = new ArrayList<>();
        testSearch.add("coaches");
        DataComp.getInstance().getFanSearchCategoryHistory().put(fan,testSearch);
        Criteria criteria = Criteria.Category;
        List<String>searchHistory = fan.retrieveSearchHistory(criteria);
        assertTrue(searchHistory.size() == 1);
        assertTrue(searchHistory.get(0).equals("coaches"));
    }

    /**
     * checks addComplaintToDataManager func
     */
    @Test
    public void addComplaintToDataManagerTest(){
        String desc = "Eitan";
        fan.addComplaintToDataManager(desc);
        assertTrue(DataComp.getInstance().getComplaint().size() == 1);
        assertTrue(DataComp.getInstance().getComplaint().get(fan.getUser()).get(0).getDescription().equals("Eitan"));
    }
}