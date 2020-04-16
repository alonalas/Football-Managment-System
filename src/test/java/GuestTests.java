import DataLayer.IDataManager;
import DataLayer.dataManager;
import LogicLayer.Fan;
import LogicLayer.Guest;
import LogicLayer.User;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GuestTests {
    private static final Logger testLogger = Logger.getLogger(GuestTests.class);
    private static Guest guest;
    private static IDataManager data;

    @BeforeClass
    public static void init(){
        data = new dataManager();
        guest = new Guest(data);
    }

    /**
     * checks create new user func
     */
    @Test
    public void checkCreatingNewUser(){
        testLogger.info("Run: checkCreatingNewUser");
        User toCheck = guest.createNewUser("Eitan@gmail.com","1234","Eitan","David");
        //checks user details
        assertEquals(toCheck.getFirstName(),"Eitan");
        assertEquals(toCheck.getLastName(),"David");
        assertEquals(toCheck.getEmail(),"Eitan@gmail.com");
        assertEquals(toCheck.getPassword(),"1234");
        //checks if Role is added
        assertTrue(toCheck.getRoles().get(0) instanceof Fan);
        //checks if user added to DB
        assertTrue(data.getUserList().size() == 1);
        testLogger.info("Ended: checkCreatingNewUser");
    }

    /**
     * checks signIn func
     */
    @Test
    public void checkSignIn(){
        testLogger.info("Run: checkSignIn");
        //checks if right User returned
        User user = guest.createNewUser("Eitan@gmail.com","1234","Eitan","David");
        data.getUserList().add(user);
        User userToCheck = guest.signIn("Eitan@gmail.com","1234");
        assertTrue(userToCheck.getEmail().equals(user.getEmail()));
        //checks if wrong email entered
        userToCheck = guest.signIn("Eitab@gmail.com","1234");
        assertNull(userToCheck);
        //checks if wrong password entered
        userToCheck = guest.signIn("Eitan@gmail.com","1235");
        assertNull(userToCheck);
        testLogger.info("Ended: checkSignIn");
    }

    /**
     * checks addNewUser func
     */
    @Test
    public void addUserTest(){
        testLogger.info("Run: addUserTest");
        //init fields for specific test
        data = new dataManager();
        guest = new Guest(data);
        //check if user is null
        User user = null;
        guest.addNewUser(user,true);
        assertTrue(data.getUserList().size() == 0);
        //checks if legal user as argument added
        user = new User("Eitan@gmail.com","1234","Eitan","David",data);
        guest.addNewUser(user,true);
        assertTrue(data.getUserList().size() == 1);
        assertTrue(data.getUserList().get(0).getPassword().equals("1234"));
        testLogger.info("Ended: addUserTest");

    }

}
