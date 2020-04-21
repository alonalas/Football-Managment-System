package IntegrationTests;
import LogicLayer.User;
import ServiceLayer.Controller;
import ServiceLayer.IController;
import ServiceLayer.UserService;
import UnitTests.UserTests;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserIntegrationTests {
    private static final Logger testLogger = Logger.getLogger(UserTests.class);
    private static User user;
    private static UserService userService;
    private static IController system;

    @BeforeClass
    public static void init(){
        String propertiesPath = "log4j.properties";
        PropertyConfigurator.configure(propertiesPath);
        user = new User("Eitan@gmail.com","1234","Eitan","David");
        system = new Controller();
        userService = new UserService(user,system);
    }

    /**
     * checks logOut func
     */
    @Test
    public void logOutTest(){
        //checks if user deleted from system
        system.addUser(user);
        try{
            userService.logOut();
        }catch (Exception e){
            e.printStackTrace();
        }
        assertFalse(system.getUserServices().containsKey(user));
        assertFalse(system.getUserList().contains(user));
    }

    /**
     * checks showPersonalDetails func
     */
    @Test
    public void showPersonalDetailsTest(){
        //checks if right information returned
        List<String>personalDetails = null;
        int firstName = 0;
        int lastName = 1;
        int email = 2;
        try{
            personalDetails = userService.showPersonalInformation();
        }catch (Exception e){
            e.printStackTrace();
        }
        assertTrue(personalDetails.get(firstName).equals("Eitan"));
        assertTrue(personalDetails.get(lastName).equals("David"));
        assertTrue(personalDetails.get(email).equals("Eitan@gmail.com"));
    }

    /**
     * checks editPersonalInformation func
     */
    @Test
    public void editPersonalInformationTest(){
        //checks func with legal argument
        String firstName = "David";
        String lastName = "Eitan";
        String email = "David@gmail.com";
        try{
            userService.editPersonalInformation(firstName,lastName,email);
        }catch (Exception e){
            e.printStackTrace();
        }
        assertTrue(user.getFirstName().equals("David"));
        assertTrue(user.getLastName().equals("Eitan"));
        assertTrue(user.getEmail().equals("David@gmail.com"));
        //check func with illegal arguments
        firstName = null;
        try{
            assertFalse(userService.editPersonalInformation(firstName,lastName,email));
        }catch (Exception e){
            e.printStackTrace();
        }
        lastName = null;
        try{
            assertFalse(userService.editPersonalInformation(firstName,lastName,email));
        }catch (Exception e){
            e.printStackTrace();
        }
        email = null;
        try{
            assertFalse(userService.editPersonalInformation(firstName,lastName,email));
        }catch (Exception e){
            e.printStackTrace();
        }
        //check func with illegal mail
        firstName = "David";
        lastName = "Eitan";
        email = "Davidgmail.com";
        try{
            assertFalse(userService.editPersonalInformation(firstName,lastName,email));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
