package UnitTests;

import DataLayer.IDataManager;
import DataLayer.dataManager;
import LogicLayer.Guest;
import LogicLayer.Page;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PageTests {
    private static final Logger testLogger = Logger.getLogger(Page.class);
    private static Page testPage;

    @BeforeClass
    public static void init(){
       testPage = new Page(null);
        String propertiesPath = "log4j.properties";
        PropertyConfigurator.configure(propertiesPath);
    }

    /**
     * test addUpdate func
     */
    @Test
    public void testAddUpdate(){
        testLogger.info("Run: testAddUpdate");
        String update = null;
        //check if String with length of 0 doesnt added to page updates
        update = "";
        testPage.addUpdate(update);
        assertTrue(testPage.getUpdates().size() == 0);
        //checks if null is added to page updates
        update = null;
        testPage.addUpdate(update);
        assertTrue(testPage.getUpdates().size() == 0);
        //checks if legal update is added to page
        update = "test update";
        testPage.addUpdate(update);
        assertTrue(testPage.getUpdates().get(0).equals(update));
        testLogger.info("Ended: testAddUpdate");
    }


}
