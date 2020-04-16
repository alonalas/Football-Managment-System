import DataLayer.IDataManager;
import DataLayer.dataManager;
import LogicLayer.*;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FanTests {
    private static final Logger testLogger = Logger.getLogger(GuestTests.class);
    private static Fan fan;
    private static User user;
    private static IDataManager data;

    @BeforeClass
    public static void init(){
        data = new dataManager();
        user = new User("Eitan@gmail.com","1234","Eitan","David",data);
        fan = new Fan(user,user.getFirstName());
    }

    /**
     * checks addPages func
     */
    @Test
    public void addPagesTest(){
        testLogger.info("Run: addPagesTest");
        //checks if page added
        List<Page>pages = new ArrayList<>();
        Page testPage1 = new Page(new Player(user," ",null," ",new Date()));
        pages.add(testPage1);
        fan.addPages(pages);
        assertTrue(fan.getPages().size() == 1);
        //checks if right page added
        testPage1.addUpdate("Eitan");
        assertEquals("Eitan",testPage1.getUpdates().get(0));
        testLogger.info("Ended: addPagesTest");
    }

}
