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

    @Test
    public void addPagesTest(){
        List<Page>pages = new ArrayList<>();
        Page testPage1 = new Page(new Player(user," ",null," ",new Date(),null));
        pages.add(testPage1);
        fan.addPages(pages);
        assertTrue(fan.getPages().size() == 1);
    }

}
