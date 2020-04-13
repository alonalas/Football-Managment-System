package LogicLayer;

import DataLayer.dataManager;
import ServiceLayer.IController;

import java.time.LocalDate;
import java.util.List;

public class Administrator extends User{
    private DataLayer.dataManager dataManager;

    public Administrator(String email, String password, String userName,dataManager dataManager) {
        super(email,password,userName);
        this.dataManager=dataManager;
    }




    /**
     * ID: Administrator@1
     * UC: 8.1
     * closes the team and inform the managers and the owner of the team
     * @param team the team we want to close
     */
    public void closeTeam(Team team){
        String date = LocalDate.now().toString();
        for(Team allTeams: dataManager.getTeamList()){
            if(team.equals(allTeams)){
                team.finalCloseTeam();
                System.out.println("team closed");
                break;
            }
        }
        for(Owner owner: team.getOwnerList()){
            Alert alert = new Alert(owner,"The team: "+ team.getName(),date);
            owner.addAlert(alert);
        }
        for(Manager manager: team.getManagerList()){
            Alert alert = new Alert(manager,"The team: "+ team.getName(),date);
            manager.addAlert(alert);
        }
    }
}
