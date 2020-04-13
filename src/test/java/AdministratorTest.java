import LogicLayer.Administrator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdministratorTest {
    // Tester
    private static Administrator administrator;
    // Logger
    private static final Logger testLogger = Logger.getLogger(AdministratorTest.class);

    // This Function Run Before All LogicLayer.Administrator Tests
    @BeforeClass
    public static void init(){
        // Init LogicLayer.Administrator Tester
        administrator = new Administrator(
                "test@example.com",
                "123456",
                "admin",
                null,
                null
        );
        String propertiesPath = "log4j.properties";
        PropertyConfigurator.configure(propertiesPath);
        testLogger.info("Start Testing: AdministratorTests");
    }

    // Simple Test For Example
    @Test
    public void testPasswordContent(){
        testLogger.info("Run: testPasswordContent");
        assertEquals("Password is incorrect", "123456", administrator.getPassword());
        testLogger.info("Ended: testPasswordContent");
    }

    @Test
    public void testPasswordLength(){
        testLogger.info("Run: testPasswordLength");
        assertEquals("Password Length Is Wrong", 6, administrator.getPassword().length()); // 6 need to be
        testLogger.info("Ended: testPasswordLength");
    }

    @AfterClass
    public static void close(){
        testLogger.info("All Tests Completed");
    }
}