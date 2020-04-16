import DataLayer.IDataManager;
import DataLayer.dataManager;
import LogicLayer.Guest;
import LogicLayer.User;
import ServiceLayer.Controller;
import ServiceLayer.GuestService;
import ServiceLayer.IController;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GuestServiceTests {
    private static final Logger testLogger = Logger.getLogger(GuestTests.class);
    private static GuestService guestService;
    private static IDataManager data;
    private static Guest guest;
    private static IController system;


    @BeforeClass
    public static void init(){
        system = new Controller();
        data = new dataManager();
        guest = new Guest(data);
        guestService = new GuestService(guest,system);
    }

    /**
     * checks Authentication func
     */
    @Test
    public void AuthenticationTest(){
        testLogger.info("Run: AuthenticationTest");
        String password = "";
        //check password contains unSupported letters
        password = "/-789";
        assertFalse(guestService.Authentication(password));
        //checks password with size less than 8
        password = "1234567";
        assertFalse(guestService.Authentication(password));
        //check legal password
        password = "12345687";
        assertTrue(guestService.Authentication(password));
        testLogger.info("Ended: AuthenticationTest");
    }

    /**
     * checks register func
     */
    @Test
    public void registerTest(){
        testLogger.info("Run: registerTest");
        //checks register with user with the same email that exists
        User user = new User("Eitan@gmail.com","1234","Eitan","David",data);
        data.addNewUser(user);
        String firstName = "Eitan";
        String lastName = "David";
        String Email = "Eitan@gmail.com";
        String password = "12345687";
        assertFalse(guestService.register(firstName,lastName,Email,password));
        //checks register func with illegal password
        password = "1234";
        Email = "walla@walla.com";
        assertFalse(guestService.register(firstName,lastName,Email,password));
        //checks register func with legal arguments
        password = "13245678";
        assertTrue(guestService.register(firstName,lastName,Email,password));
        testLogger.info("Ended: registerTest");
    }


}
