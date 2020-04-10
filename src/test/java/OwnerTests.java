import DataLayer.dataManager;
import LogicLayer.*;
import ServiceLayer.Controller;
import ServiceLayer.OwnerService;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

//Alona
public class OwnerTests{

    dataManager dataManager = new dataManager();
    Controller controller = new Controller(null,null);
    User ownerUser = new User("alonalas@post.bgu.ac.il","123","alona");
    User u1 = new User("a@b@c","1234","alonalas");
    OwnerService os = new OwnerService(controller);
    Owner own = new Owner(ownerUser,"ssss",dataManager);
    Team team = new Team("Blumfield", "Hapoel",null, null);


    @Test
    public void testOwnerAddAsset() throws IOException {

        controller.addUser(ownerUser);
        dataManager.addUser(ownerUser);
        dataManager.addUser(u1);
        ownerUser.setRole(own);
        own.addTeam(team);
        os.insertNewAssetType(own);

    }
}
