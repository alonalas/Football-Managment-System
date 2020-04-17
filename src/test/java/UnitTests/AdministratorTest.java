package UnitTests;

import DataLayer.dataManager;
import LogicLayer.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdministratorTest {
    private Administrator administrator;
    private Team team1;
    private Team team2;
    private Owner owner1;
    private Owner owner2;
    private Manager manager1;
    private Manager manager2;
    private User user1;
    private User user2;
    private User user3;


    @Before
    public void init(){
        DataComp.setDataManager(new dataManager());
        team1=new Team("hapoel","blumfield",null);
        team2=new Team("macabi","stadium",null);
        DataComp.getInstance().addTeam(team1);
        DataComp.getInstance().addTeam(team2);

        user1 = new User("email","aaa","theQueen");
        user2 = new User("aa","ss","dd");
        user3 = new User("ww","ee","rr");
        owner1 = new Owner(user1,"haim");
        owner1.addTeam(team1);
        owner2 = new Owner(user2,"moshe");
        owner2.addTeam(team2);
        manager1 = new Manager(user1,"haim",team1);
        manager2 = new Manager(user3,"yossi",team2);
        DataComp.getInstance().addUser(user1);
        DataComp.getInstance().addUser(user2);

        team1.addOwner(owner1);
        team2.addOwner(owner2);
        team1.addManager(manager1);
        team2.addManager(manager2);

        administrator= new Administrator("aa","scv","jdjdj");



    }

    @Test
    public void closeTeam(){
        for(Team team: DataComp.getInstance().getTeamList()){
            System.out.println(team.getName()+ " " + team.isFinalClose());
        }
        for(Alert alert: manager2.getAlerts()){
            System.out.println(alert.getDescription());
        }
        for(Alert alert: owner2.getAlerts()){
            System.out.println(alert.getDescription());
        }
        administrator.closeTeam(team2);
        for(Team team: DataComp.getInstance().getTeamList()){
            System.out.println(team.getName()+ " " + team.isFinalClose()); // macabi is true
        }

        for(Alert alert: manager2.getAlerts()){
            System.out.println(alert.getDescription());
        }
        for(Alert alert: owner2.getAlerts()){
            System.out.println(alert.getDescription());
        }
    }

    @Test
    public void showComplaints(){
        Complaint complaint1 = new Complaint(user1,"bad","2012-12-12");
        Complaint complaint2 = new Complaint(user2,"good","2018-12-13");
        DataComp.getInstance().addComplaint(complaint1,user1);
        DataComp.getInstance().addComplaint(complaint2,user2);

        administrator.showComplaints();

    }

    @Test
    public void CommentComplaint(){
        Complaint complaint1 = new Complaint(user1,"bad","2012-12-12");
        Complaint complaint2 = new Complaint(user2,"good","2018-12-13");
        DataComp.getInstance().addComplaint(complaint1,user1);
        DataComp.getInstance().addComplaint(complaint2,user2);

        administrator.showComplaints();

        System.out.println();
        administrator.commentComplaint(complaint1,"very good complaint");
        administrator.showComplaints();

    }


    @Test
    public void deleteUser(){
        System.out.println(user2.getRoles().size());
        for(User user : DataComp.getInstance().getUserList()){
            System.out.println(user.getUserName());
        }
        for(Owner owner: team1.getOwnerList()) {
            System.out.println(owner.getName());
        }
        administrator.deleteUser(user2);
        for(Owner owner: team1.getOwnerList()) {
            System.out.println(owner.getName());
        }
        for(User user : DataComp.getInstance().getUserList()){
            System.out.println(user.getUserName());
        }
        for(Manager manager: team2.getManagerList()){
            System.out.println(manager.getName());
        }
    }


}
