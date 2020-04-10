import LogicLayer.*;
import ServiceLayer.Controller;
import ServiceLayer.OwnerService;
import org.junit.Test;

import java.io.IOException;

//Alona
public class OwnerTests {

    @Test
    public void testOwnerAddAsset() throws IOException {
        Controller controller = new Controller(null,null);

        OwnerService os = new OwnerService(controller);

        Coach p = new Coach(null,"aaaa","sasa","dasdsad",null,null);
        Owner own = new Owner(null,"ssss",null,os);
        Team team = new Team(null,null,null,null,null,null,null,null,null);
        User user = new User("aaa","123","alona",controller,null);
        os.InsertNewAssetType(own,false,team,user);

    }
}
