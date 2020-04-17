package UnitTests;

import DataLayer.IDataManager;
import DataLayer.dataManager;
import LogicLayer.DataComp;
import LogicLayer.Guest;
import LogicLayer.Player;
import LogicLayer.User;
import ServiceLayer.*;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuestServiceTests {
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

    /**
     * checks show information by category func
     */
    @Test
    public void showInfoTest() {
        GuestStub guest = new GuestStub();
        guestService = new GuestService(guest, system);
        guestService.showInformationByCategory(Interest.Players);
        assertEquals(guestService.getLastSearchResults().size(),guest.retrievePlayers().size());
        assertNotEquals(guestService.getLastSearchResults().size(), 0);
        assertArrayEquals(guestService.getLastSearchResults().toArray(),guest.retrievePlayers().toArray());
        guestService.showInformationByCategory(Interest.Games);
        assertNotEquals(guestService.getLastSearchResults().size(), 3);
        assertEquals(guestService.getLastSearchResults().size(), 2);
    }

    /**
     * checks search information func
     */
    @Test
    public void searchInfoTest() {
        GuestStub guest = new GuestStub();
        guestService = new GuestService(guest, system);
        // Search By Key Word
        guestService.searchInformation(Criteria.KeyWord, "David");
        assertEquals(((User)guestService.getLastSearchResults().get(0)).getFirstName(),"David");
        assertEquals(guestService.getLastSearchResults().size(), 1);
        // Search By Name
        guestService.searchInformation(Criteria.Name, "David");
        assertEquals(((User)guestService.getLastSearchResults().get(0)).getFirstName(),"David");
        assertEquals(guestService.getLastSearchResults().size(), 1);
        // Search By Category
        guestService.searchInformation(Criteria.Category, "plaYErs");
        assertEquals(((Player)guestService.getLastSearchResults().get(0)).getName(),"David");
        assertEquals(guestService.getLastSearchResults().size(), 3);
    }

    /**
     * checks filter search results func
     */
    @Test
    public void filterSearchTest() {
        GuestStub guest = new GuestStub();
        guestService = new GuestService(guest, system);
        // Search By Key Word
        guestService.searchInformation(Criteria.KeyWord, "playERS");
        guestService.filterResults(Filter.Team, "FCB");
    }
}
