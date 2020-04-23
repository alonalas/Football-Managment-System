package AcceptanceTests;
import DataLayer.dataManager;
import LogicLayer.*;
import ServiceLayer.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;


public class AdministratorAcceptanceTest {
    private static IController system;
    private static User user ;
    private static Representitive representative ;
    private static Guest guest;
    private static IGuestService guestService;
    private static RepresentativeService representativeService;
    public static AdministratorService administratorService;

    private static Team team;
    private static User user1;

    private static Owner owner;
    private static User user2;

    private static Player player;
    private static User user3;

    private static Manager manager;
    private static User user4;

    @BeforeClass
    public static void beforeClass() throws Exception {
        DataComp.setDataManager(new dataManager());
        Administrator administrator = new Administrator("A", "B", "C");
        user = new User("AA", "BB", "CC");
        representative = new Representitive(user, "lama name");
        user.addRole(representative);
        system = new Controller(representative, administrator);

        guest = new Guest();
        system.addGuest(guest);
        guestService = system.getGuestServices().get(guest);

        user1 = guestService.register("Lior","Eitan","Lior@gmail.com","12345678");
        representativeService= (RepresentativeService) system.getUserServices().get(user).get(1);

    }


    public void getTheRole(){
        for(Role role: user1.getRoles()){
            if(role instanceof Owner){
                owner=(Owner) role;
            }
        }
    }


    @Test
    public void displayLog(){
        administratorService.displayLog();
    }


    @Test
    public void displayComplaints(){
        administratorService.showComplaints();
        assertTrue(administratorService.showComplaints().size()==0); // prints that there isn't a complaint in the system
        Complaint complaint1 = new Complaint(user1, "bad", "2012-12-12");
        Complaint complaint2 = new Complaint(user2, "good", "2018-12-13");
        DataComp.getInstance().addComplaint(complaint1, user1);
        DataComp.getInstance().addComplaint(complaint2, user2);
        administratorService.showComplaints();
        assertTrue(administratorService.showComplaints().size()==2);
    }


    @Test
    public void respondComplaint(){
        Complaint complaint1 = new Complaint(user1, "bad", "2012-12-12");
        Complaint complaint2 = new Complaint(user2, "good", "2018-12-13");
        DataComp.getInstance().addComplaint(complaint1, user1);
        DataComp.getInstance().addComplaint(complaint2, user2);
        assertFalse(complaint1.isAnswered());
        assertFalse(complaint2.isAnswered());

        administratorService.commentComplaint(complaint1,"aaa");
        administratorService.commentComplaint(complaint1,"Aa"); // prints that the admin already responded

        assertTrue(complaint1.isAnswered());
    }







}
