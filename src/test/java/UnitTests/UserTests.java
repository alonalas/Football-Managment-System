package UnitTests;

import DataLayer.IDataManager;
import DataLayer.dataManager;
import LogicLayer.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;


import static org.junit.Assert.assertTrue;

public class UserTests {
    private static final Logger testLogger = Logger.getLogger(UserTests.class);
    private static User user;
    private static IDataManager data;

    @BeforeClass
    public static void init(){
        String propertiesPath = "log4j.properties";
        PropertyConfigurator.configure(propertiesPath);
        data = new dataManager();
        user = new User("Eitan@gmail.com","1234","Eitan","David");
    }

    /**
     * checks getPersonalDetails func
     */
    @Test
    public void checkGetPersonalDetails(){
        //tests personal details getter
        testLogger.info("Run: checkGetPersonalDetails");
        List<String>personalDetail = user.getPersonalDetails();
        assertTrue(personalDetail.get(0).equals("Eitan"));
        assertTrue(personalDetail.get(1).equals("David"));
        assertTrue(personalDetail.get(2).equals("Eitan@gmail.com"));
        testLogger.info("Ended: checkGetPersonalDetails");
    }

    /**
     * checks updatePersonalDetails func
     */
    @Test
    public void updatePersonalDetailCheck(){
        //check if details updated by entering legal values
        testLogger.info("Run: updatePersonalDetailCheck");
        String firstName = "David";
        String lastName = "Eitan";
        String email = "David@gmail.com";
        user.updatePersonalInformation(firstName,lastName, email);
        assertTrue(user.getFirstName().equals("David"));
        assertTrue(user.getLastName().equals("Eitan"));
        assertTrue(user.getEmail().equals("David@gmail.com"));
        //check if details updated with null argument
        firstName = null;
        user.updatePersonalInformation(firstName,lastName, email);
        assertTrue(user.getFirstName().equals("David"));
        testLogger.info("Ended: updatePersonalDetailCheck");
    }
}
