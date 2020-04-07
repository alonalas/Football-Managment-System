import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdministratorTests {
    // Tester
    private static Administrator administrator;
    // Logger
    private static final Logger testLogger = Logger.getLogger(AdministratorTests.class);

    // This Function Run Before All Administrator Tests
    @BeforeClass
    public static void init(){
        // Init Administrator Tester
        administrator = new Administrator(
                "test@example.com",
                "123456",
                "admin",
                null,
                null
        );
        String propertiesPath = "log4j.properties";
        PropertyConfigurator.configure(propertiesPath);
    }

    // Simple Test For Example
    @Test
    public void testPasswordContent(){
        testLogger.info("Test Run: testPasswordContent");
        assertEquals("Password is incorrect", "123456", administrator.getPassword());
        testLogger.info("Test Ended: testPasswordContent");
    }

    @Test
    public void testPasswordLength(){
        testLogger.info("Test Run: testPasswordLength");
        assertEquals("Password Length Is Wrong", 6, administrator.getPassword().length()); // 6 need to be
        testLogger.info("Test Ended: testPasswordLength");
    }

}
