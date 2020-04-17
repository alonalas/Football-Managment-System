package AcceptanceTests;

import LogicLayer.*;
import ServiceLayer.Controller;
import ServiceLayer.RepresentativeService;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


public class RepresentativeAcceptanceTest {

    @BeforeClass
    public static void SystemInit(){
        DataComp.getInstance().TestReset();
        Representitive representative = new Representitive(new User("l@gmail.com","1234","gabi"),"bingo")  ;
        Controller controller = new Controller(representative,null);
        controller.controllerSingleTone = controller ;
        controller.addUser(new User ("f@f.f","12","fadi"));
    }

    private Representitive representative ;
    private RepresentativeService representativeService ;
    private Controller controller = Controller.controllerSingleTone ;
    private List<User> users ;

    @Before
    public void init(){
        DataComp.getInstance().TestReset();
        List<User>  users = controller.getUserList();
        representativeService = new RepresentativeService(null) ;
    }

    /**
     * id: A@1
     * UC: 9.1
     */
    @Test
    public void addLeague() {
        try {
            assertTrue(representativeService.addLeague(League.LeagueType.LEAGUE_C));
            assertFalse(representativeService.addLeague(League.LeagueType.LEAGUE_C));//already exist

        } catch (Exception e) {
        }
    }

    /**
     * id: A@2
     * UC: 9.2
     */
    @Test
    public void addSeason(){
        try {
           representativeService.addLeague(League.LeagueType.LEAGUE_C);
           //------ test begins here
           League league = representativeService.showAllLeagus().get(0);
           representativeService.addSeason("2020-02-01","2020-02-03" , league);
           assertTrue(representativeService.showAllSeasons().size()==1);
        }catch (Exception e){ }
    }

    /**
     * id: A@3
     * UC: 9.3.1
     */
    @Test
    public void addReferee(){
        try {
            //----- referee not exist test
            User user = representativeService.getSystemUsers().get(0);
            representativeService.addNewRefereeFromUsers(user , "good","gabi");
            assertTrue(representativeService.showAllReferees().size() == 1);
            //----- referee exist test
            assertFalse(representativeService.addNewRefereeFromUsers(user , "good","gabi"));
            assertTrue(representativeService.showAllReferees().size() == 1);
        }catch (Exception e){ }
    }

    /**
     * id: A@4
     * UC: 9.3.2
     */
    @Test
    public void removeReferee() {
        try {
            //----- referee remove test
            User user = representativeService.getSystemUsers().get(0);
            assertTrue(representativeService.addNewRefereeFromUsers(user, "good", "gabi"));
            assertTrue(representativeService.showAllReferees().size() == 1);
            assertTrue(representativeService.removeRefereeFromUsers(user));
            assertTrue(representativeService.showAllReferees().size() == 0);
            //----- referee already removed test
            assertFalse(representativeService.removeRefereeFromUsers(user));
            assertTrue(representativeService.showAllReferees().size() == 0);
        } catch (Exception e) {
        }
    }

    /**
     * id: A@5
     * UC: 9.4
     * add first time  - Assert true
     * alreadyExist -> Assert False
     */
    @Test
    public void addApprovalForReferee(){
        try {
            addDataToSystem();
          //  ------------------- add approval test begins here
            Referee referee = representativeService.showAllReferees().get(0);
            League league = representativeService.showAllLeagus().get(0);
            Season season = representativeService.showAllSeasons().get(0);
            assertTrue(representativeService.addJudgmentApproval(referee , league ,season)) ;
            //------------------- alreadyExist approval test
            assertFalse(representativeService.addJudgmentApproval(referee , league ,season));
        }catch (Exception e){ }
    }

    /**
     * id: A@6
     * UC: 9.4
     * add first time  - Assert true
     * alreadyExist -> Assert False
     */
    @Test
    public void removeApprovalForReferee(){
        try {
            addApprovalForReferee();
            //  ----- test begins here
            Referee referee = representativeService.showAllReferees().get(0);
            League league = representativeService.showAllLeagus().get(0);
            Season season = representativeService.showAllSeasons().get(0);
            assertTrue(representativeService.removeJudgmentApproval(referee , league ,season)) ;
            //-------- test if approval already removed
            assertFalse(representativeService.removeJudgmentApproval(referee , league ,season)); ;
        }catch (Exception e){ }
    }
    /**
     * init data for UC9.4 testing
     */
    public void addDataToSystem(){
        try {
            User user = representativeService.getSystemUsers().get(0);
            representativeService.addNewRefereeFromUsers(user, "good", "gabi");
            addSeason();
        }catch (Exception e){

        }
    }
}
