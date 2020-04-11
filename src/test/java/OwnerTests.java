import DataLayer.dataManager;
import LogicLayer.*;
import ServiceLayer.Controller;
import ServiceLayer.OwnerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;


public class OwnerTests{

    dataManager dataManager = new dataManager();
    Controller controller = new Controller(null,null);
    User ownerUser = new User("alonalas@post.bgu.ac.il","123","alona");
    User u1 = new User("a@b@c","1234","alonalas");
    OwnerService os = new OwnerService(controller);
    Owner own = new Owner(ownerUser,"ssss",dataManager);
    Page p = new Page();
    Manager m = new Manager();
    Team team = new Team("Blumfield", "Hapoel",p);
    RoleHolder roleHolder = new Player(u1,"GoalKeeper",team,"yotam",null,p);

    /**
     * the 4 following tests are UC 6.1.1
     * the 4 following tests assumes owner's account is connected allready
     * the 4 following tests assumes the following process in the presentation layer:
     *
     * the owner push the button "insert new asset to team"
     * GUI shows 4 following buttons:
     * -insert new manager
     * -insert new player
     * -insert new coach
     * -insert new stadium
     * after choosing the desiered option, each of the 4 following tests corresponds to the selected option from above
     *
     *
     *
     */
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
            os.validateExistingAssetType(own,teamName, email,userName);
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
            os.validateExistingAssetType(own,teamName, email,userName);
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
            os.validateExistingAssetType(own,teamName, email,userName);
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

        String stadium = "Sami offer"; // when button "Manager" is chosen
        String teamName = "Hapoel";

        try {
            os.validateExistingAssetType(own,teamName,"X","X");
            controller.displayForm(null);
            os.insertNewStadium(own,teamName,stadium);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    /**
     * tests asset deletion
     * asset is one of the following options: Player/Coach/Manager
     * assumes that the user have chosen the button "RoleHolder-> chosen role from abocve)
     * you need to change the creation of the RoleHolder datatype to which you want to check according to the chosen data type
     * from above
     */
    public void testOwnerDeleteAsset() {

        testOwnerAddPlayer(); // player Exists in the system
        RoleHolder toDelete = new Player(u1,"GoalKeeper",team,"David",null,p);

        String userName = "alonalas";
        String email = "a@b@c";
        String teamName = "Hapoel";

        try {
            os.validateExistingAssetType(own,teamName,email,userName);
            os.deleteAsset(own,teamName,userName,email,toDelete);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    /**
     * test stadium deletion
     * assumes that the user have chosen the button "stadium"
     */
    public void testDeleteStadium() {

        String teamName = "Hapoel";
        String stadium = "Blumfield";

        try {
            os.validateExistingAssetType(own,teamName,"X","X");
            os.deleteStadium(own,teamName,stadium);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }





}
