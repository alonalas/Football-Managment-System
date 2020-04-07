import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdministratorTests {
    // Tester
    private static Administrator administrator;

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
    }

    // Simple Test For Example
    @Test
    public void testPasswordContent(){
        assertEquals("Password is incorrect", "123456", administrator.getPassword());
    }

    @Test
    public void testPasswordLength(){
        assertEquals("Password Length Is Wrong", 5, administrator.getPassword().length()); // 6 need to be
    }
}
