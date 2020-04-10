import DataLayer.dataManager;
import LogicLayer.*;
import ServiceLayer.Controller;
import ServiceLayer.OwnerService;
import org.junit.Test;
import java.io.IOException;

//Alona
public class OwnerTests{

    dataManager dataManager = new dataManager();
    Controller controller = new Controller(null,null);
    User ownerUser = new User("alonalas@post.bgu.ac.il","123","alona");
    User u1 = new User("a@b@c","1234","alonalas");
    OwnerService os = new OwnerService(controller);
    Owner own = new Owner(ownerUser,"ssss",dataManager);
    Page p = new Page();
    Manager m = new Manager();
    Team team = new Team("Blumfield", "Hapoel",p, m);

    @Test
    public void testOwnerAddManager() {

        controller.addUser(ownerUser);
        dataManager.addUser(ownerUser);
        dataManager.addUser(u1);
        ownerUser.setRole(own);
        own.addTeam(team);
        team.addOwner(own);

        String userName = "alonalas";
        String email = "a@b@c";
        String teamName = "Hapoel";
        Manager m1 = new Manager(); // when button "Manager" is chosen

        try {
            os.validateNewAssetType(own,teamName, email,userName);
            controller.displayForm(m1);
            os.insertNewManager(own,teamName, "Yossi", userName,email);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    @Test
    public void testOwnerAddCoach() {

        controller.addUser(ownerUser);
        dataManager.addUser(ownerUser);
        dataManager.addUser(u1);
        ownerUser.setRole(own);
        own.addTeam(team);

        String userName = "alonalas";
        String email = "a@b@c";
        String teamName = "Hapoel";
        Coach c = new Coach(); // when button "Manager" is chosen

        try {
            os.validateNewAssetType(own,teamName, email,userName);
            controller.displayForm(c);
            os.insertNewCoach(own,teamName,"Dani","university of life","fitting rooms", userName,email);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testOwnerAddPlayer() {

        controller.addUser(ownerUser);
        dataManager.addUser(ownerUser);
        dataManager.addUser(u1);
        ownerUser.setRole(own);
        own.addTeam(team);

        String userName = "alonalas";
        String email = "a@b@c";
        String teamName = "Hapoel";
        Player p = new Player(); // when button "Manager" is chosen

        try {
            os.validateNewAssetType(own,teamName, email,userName);
            controller.displayForm(p);
            os.insertNewPlayer(own,teamName,"David","GoalKeeper",1,2,1995,userName,email);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testOwnerAddStadium() {

        controller.addUser(ownerUser);
        dataManager.addUser(ownerUser);
        dataManager.addUser(u1);
        ownerUser.setRole(own);
        own.addTeam(team);

        String stadium = "Stadium"; // when button "Manager" is chosen
        String teamName = "Hapoel";

        try {
            os.validateNewAssetType(own,teamName,"X","X");
            controller.displayForm(null);
            os.insertNewStadium(own,teamName,stadium);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }




}
