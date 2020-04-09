import com.google.gson.Gson;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import LogicLayer.User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GSonTests {
    private static User testUser;
    private static Gson JSON;
    private static User result;

    @BeforeClass
    public static void initTests(){
        testUser = new User("PA","SS","ED",null,null);
        JSON = new Gson();
//        String jsonString = JSON.toJson(testUser);
//        result = JSON.fromJson(jsonString, User.class);
        // Write Json To File
        try {
            FileWriter writer = new FileWriter(new File("configurations.json"),true);
            JSON.toJson(testUser, writer);
            writer.close();
            result = JSON.fromJson(new FileReader(new File("configurations.json")), User.class);
        }catch (Exception IOE){
            System.out.println("AH AH!");
            System.out.println();
        }
    }

    @Test
    public void testA(){
        assertEquals(testUser.getUserName(),result.getUserName());
    }

    @Test
    public void testB() {
        assertEquals(testUser.getPassword(),result.getPassword());
    }

    @Test
    public void testC() {
        assertEquals(testUser.getEmail(),result.getEmail());
    }

    @AfterClass
    public static void finish() {
        System.out.println(result.getEmail()+result.getPassword()+result.getUserName());
    }
}
