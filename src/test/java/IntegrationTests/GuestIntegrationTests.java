package IntegrationTests;

import DataLayer.dataManager;
import LogicLayer.DataComp;
import LogicLayer.Guest;
import LogicLayer.User;
import ServiceLayer.*;
import UnitTests.GuestTests;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GuestIntegrationTests {
    private static final Logger testLogger = Logger.getLogger(GuestTests.class);
    private static GuestService guestService;
    private static Guest guest;
    private static IController system;

    @Before
    public void setUp() throws Exception {
        DataComp.setDataManager(new dataManager());
    }



    @BeforeClass
    public static void init(){
        system = new Controller();
        guest = new Guest();
        guestService = new GuestService(guest,system);
        String propertiesPath = "log4j.properties";
        PropertyConfigurator.configure(propertiesPath);
    }

    /**
     * checks register func
     */
    @Test
    public void registerTest(){
        testLogger.info("Run: registerTest");
        //checks register while user with the same email that exists
        User user = new User("Eitan@gmail.com","1234","Eitan","David");
        DataComp.getInstance().addNewUser(user);
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
        assertTrue(system.getUserList().size() == 1);
        user.setPassword("13245678");
        user.setFirstName("Eitan");
        user.setEmail("walla@walla.com");
        //checks if user added to controller
        assertTrue(system.getUserList().get(0).equals(user));
        //checks if userService and fanService added to user
        assertTrue(system.getUserServices().get(user).size() == 2);
        assertTrue(system.getUserServices().get(user).get(0) instanceof UserService);
        assertTrue(system.getUserServices().get(user).get(1) instanceof FanService);
        testLogger.info("Ended: registerTest");
    }

    /**
     * checks log in func
     */
    @Test
    public void logInTest(){
        testLogger.info("Run: logInTest");
        //check log in with illegal password
        User user = new User("Eitan@gmail.com","12345678","Eitan","David");
        DataComp.getInstance().addNewUser(user);
        assertFalse(guestService.logIn("Eitan@gmail.com","123456"));
        //check log in with incorrect email
        assertFalse(guestService.logIn("Eitab@gmail.com","12345678"));
        //check legal arguments log in
        assertTrue(guestService.logIn("Eitan@gmail.com","12345678"));
        testLogger.info("Ended: logInTest");
    }
}
