package UnitTests;

import DataLayer.dataManager;
import LogicLayer.*;
import ServiceLayer.Controller;
import ServiceLayer.OwnerService;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;


public class OwnerTest {

    dataManager dataManager = new dataManager();
    Controller controller = new Controller(null,null);

    User ownerUser = new User("alonalas@post.bgu.ac.il","123","alona");
    User u1 = new User("a@b@c","1234","alonalas");
    User u2 = new User("amir@post", "234","amirLasry");

    OwnerService os = new OwnerService(controller);
    Owner own = new Owner(ownerUser,"Alona the queen",dataManager);
    Page p = new Page();
    Team team = new Team("Blumfield", "Hapoel",p, dataManager);

    /**
     * the 5 following tests are testing UC 6.1.1
     * the 5 following tests assumes owner's account is connected allready
     * the 5 following tests assumes the following process in the presentation layer:
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

        assertTrue(team.getManagerList().size() > 0);
        assertNotNull(team.getRoleHolder(own,userName,email));
    }


    @Test
    public void testOwnerAddCoach() {

        controller.addUser(ownerUser);
        dataManager.addUser(ownerUser);
        dataManager.addUser(u1);
        ownerUser.setRole(own);
        own.addTeam(team);
        team.addOwner(own);

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
        assertTrue(team.getCoachList().size() > 0);
        assertNotNull(team.getRoleHolder(own,userName,email));
    }

    @Test
    public void testOwnerAddPlayer() {

        controller.addUser(ownerUser);
        dataManager.addUser(ownerUser);
        dataManager.addUser(u1);
        ownerUser.setRole(own);
        own.addTeam(team);
        team.addOwner(own);

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

        assertTrue(team.getPlayerList().size() > 0);
        assertNotNull(team.getRoleHolder(own,userName,email));

    }

    @Test
    public void testOwnerAddStadium() {

        controller.addUser(ownerUser);
        dataManager.addUser(ownerUser);
        dataManager.addUser(u1);
        ownerUser.setRole(own);
        own.addTeam(team);
        team.addOwner(own);

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
        assertEquals(team.getStadium(),stadium);
    }

    @Test
    public void checkExceptionThrown() {

        controller.addUser(ownerUser);
        dataManager.addUser(ownerUser);
        dataManager.addUser(u1);
        ownerUser.setRole(own);
        own.addTeam(team);
        team.addOwner(own);

        boolean thrown = false;
        String message="";

        try {
            check("Hapoel", "aaa", "bbb", new Manager());
        }
        catch (IOException e) {
            thrown = true;
            message = e.getMessage();
        }
        assertTrue(thrown);
        assertEquals(message,"The chosen user does not exist, please insert valid inputs");

        try {
            check("Beitar", "a@b@c", "alonalas", new Manager());
        }
        catch (IOException e) {
            thrown = true;
            message = e.getMessage();
        }
        assertTrue(thrown);
        assertEquals(message,"The chosen team does not exist, please choose a valid team");

    }

    public void check(String teamName, String email, String userName, RoleHolder roleHolder) throws IOException {
        os.validateExistingAssetType(own,teamName, email,userName);
        controller.displayForm(roleHolder);
        os.insertNewManager(own,teamName, "xxx", userName,email);
    }

    @Test
    /**
     * The following 2 test are testing U.C 6.1.2
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
            os.deleteRoleHolder(own,teamName,userName,email,toDelete);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        assertTrue(team.getPlayerList().size() == 0);
        assertNull(team.getRoleHolder(own,userName,email));

    }

    @Test
    /**
     * test stadium deletion
     * assumes that the user have chosen the button "stadium"
     */
    public void testOwnerDeleteStadium() {

        controller.addUser(ownerUser);
        dataManager.addUser(ownerUser);
        dataManager.addUser(u1);
        ownerUser.setRole(own);
        own.addTeam(team);
        team.addOwner(own);

        String teamName = "Hapoel";
        String stadium = "Blumfield";

        try {
            os.validateExistingAssetType(own,teamName,"X","X");
            os.deleteStadium(own,teamName,stadium);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(team.getStadium(),"NO_STADIUM");

    }

    /*
    @Test
    public void testOwnerUpdateAsset() {

        testOwnerAddPlayer(); // player Exists in the system
        RoleHolder toUpdate = team.getRoleHolder(own,u1.getUserName(),u1.getEmail());

        String userName = "alonalas";
        String email = "a@b@c";
        String teamName = "Hapoel";

        String newUserName = "alonalas";
        try {
            os.validateExistingAssetType(own,teamName,email,userName);
            os.updateRoleHolder(toUpdate);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        assertTrue(team.getPlayerList().size() == 0);
        assertNull(team.getRoleHolder(own,userName,email));
    }
*/

    ////////////////////////////////////////////////////////////////uc2

    /**
     * test U.C 6.2
     * current owner nominates another owner as an addition owner of a requiered team
     * @throws IOException in the following cases:
     * -chosen owner is allrady nominated
     * -chosen user does not exist in the system
     * -owner does not owe the requeierd team.
     */
    @Test
    public void testOwnerNominateOwner() {

        initializeSystem();
        String name = "newOnwerCher";

        try {
            os.nominateNewOwner(own,team,u2,name);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        assertNotNull(team.getOwner(u2));
        assertTrue(u2.getRoles().size() == 1);
        assertTrue(team.getOwnerList().size() == 2);

        try {
            os.nominateNewOwner(own,team,u2,name);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(),"User is allready nominated as owner in this team");
        }

    }

    private void initializeSystem() {

        controller.addUser(ownerUser);
        dataManager.addUser(ownerUser);
        dataManager.addUser(u1);
        dataManager.addUser(u2);
        ownerUser.setRole(own);
        own.addTeam(team);
        team.addOwner(own);

    }






}
