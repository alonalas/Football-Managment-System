package UnitTests;

import LogicLayer.Guest;
import LogicLayer.User;
import ServiceLayer.Controller;
import ServiceLayer.IController;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.*;

import static org.junit.Assert.*;

public class ControllerTest {
    // Logger
    private static final Logger testLogger = Logger.getLogger(ControllerTest.class);
    // System
    IController systemTester = new Controller();
    // Test Components
    User validUser = new User("mail@gamil.com", "12345678", "test");
    Guest validGuest = new Guest();

    /**
     *  initialization tests
     */
    @BeforeClass
    public static void init(){
        // Initialization of the Logger
        String propertiesPath = "log4j.properties";
        PropertyConfigurator.configure(propertiesPath);
        testLogger.info("System Tests : Started");
    }

    /**
     *  reset IController before tests
     */
    @Before
    public void setUp(){
        systemTester = new Controller();
    }

    /**
     *  checks add user func
     */
    @Test
    public void addUserTest() {
        assertTrue(systemTester.addUser(validUser));
        assertFalse(systemTester.addUser(null));
    }

    /**
     *  checks remove user func
     */
    @Test
    public void removeUserTest() {
        systemTester.addUser(validUser);
        assertEquals(1, systemTester.getUserList().size());
        systemTester.removeUser(validUser);
        assertEquals(0, systemTester.getUserList().size());
    }

    /**
     *  checks add guest func
     */
    @Test
    public void addGuestTest() {
        systemTester.addGuest(validGuest);
        assertEquals(1, systemTester.getGuestsList().size());
        systemTester.addGuest(null);
        assertEquals(1, systemTester.getGuestsList().size());
    }

    /**
     *  checks remove guest func
     */
    @Test
    public void removeGuestTest() {
        systemTester.addGuest(validGuest);
        assertEquals(1, systemTester.getGuestsList().size());
        systemTester.removeGuest(validGuest);
        assertEquals(0, systemTester.getGuestsList().size());
    }

    /**
     *  checks remove user services func
     */
    @Test
    public void removeUserServiceTest() {
        systemTester.addUser(validUser);
        assertEquals(1, systemTester.getUserServices().getOrDefault(validUser,null).size());
        systemTester.removeUserService(validUser);
        assertNull(systemTester.getUserServices().getOrDefault(validUser,null));
    }

    /**
     *  check create fan service func
     */
    @Test
    public void createFanServiceForUserTest() {
        systemTester.addUser(validUser);
        assertNotEquals(2, systemTester.getUserServices().get(validUser).size());
        assertEquals(1, systemTester.getUserServices().get(validUser).size());
//        systemTester.createFanServiceForUser(validUser);
    }

    /**
     *
     */
    @Test
    public void addServicesToUserTest() {

    }

    /**
     * closing tests
     */
    @AfterClass
    public static void afterClass(){
        testLogger.info("System Tests : Ended");
    }
}
