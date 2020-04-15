package LogicLayer;

import DataLayer.dataManager;
import ServiceLayer.IController;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Ref;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Administrator extends User {
    private DataLayer.dataManager dataManager;
    private static final Logger systemLoger = Logger.getLogger(dataManager.class);

    public Administrator(String email, String password, String userName, dataManager dataManager) {
        super(email, password, userName);
        this.dataManager = dataManager;
    }


    /**
     * ID: Administrator@1
     * UC: 8.1
     * closes the team and inform the managers and the owner of the team
     *
     * @param team the team we want to close
     */
    public void closeTeam(Team team) {
        String date = LocalDate.now().toString();
        for (Team allTeams : dataManager.getTeamList()) {
            if (team.equals(allTeams)) {
                team.finalCloseTeam();
                System.out.println("team closed");
                String propertiesPath = "log4j.properties";
                PropertyConfigurator.configure(propertiesPath);
                systemLoger.info("team closed");
                break;
            }
        }
        for (Owner owner : team.getOwnerList()) {
            Alert alert = new Alert(owner.getUser(), "The team: " + team.getName() + " is close for good", date);
            owner.addAlert(alert);
            dataManager.addAlert(alert, owner.getUser());
        }
        for (Manager manager : team.getManagerList()) {
            Alert alert = new Alert(manager.getUser(), "The team: " + team.getName() + " is close for good", date);
            manager.addAlert(alert);
            dataManager.addAlert(alert, manager.getUser());
        }
    }


    /**
     * ID: Adminstrator@2
     * UC: 8.3.1
     * display all the complaints's details
     */
    public void showComplaints() {
        Collection<List<Complaint>> complaints = dataManager.getComplaint().values();
        for (List<Complaint> list : complaints) {
            for (Complaint com : list) {
                System.out.println(com.getFullComplaint());
            }
        }

    }


    /**
     * ID: Adminstrator@3
     * UC: 8.3.2
     * adds comment to the complaint
     *
     * @param complaint the complaint
     * @param commend   the commend the admin wants to add
     */
    public void commentComplaint(Complaint complaint, String commend) {
        for (List<Complaint> list : dataManager.getComplaint().values()) {
            for (Complaint com : list) {
                if (complaint.equals(com)) {
                    com.setCommentAdmin(commend);
                    Alert alert = new Alert(com.getUser(), "the admin commened your complaint", LocalDate.now().toString());
                    com.getUser().addAlerts(alert);
                    dataManager.addAlert(alert, com.getUser());
                    break;
                }
            }
        }
    }


    /**
     * ID: Administrator@4
     * UC 8.2
     * deletes a user
     *
     * @param user the user we want to delete
     */
    public void deleteUser(User user) {
        boolean cantBeDelete = false;
        for (Iterator<Role> iterator = user.getRoles().iterator(); iterator.hasNext(); ) {
            Role role = iterator.next();
            if (!cantBeDelete) {
                if (role instanceof Owner) {
                    for (Team team : ((Owner) role).getTeamList()) {
                        if (team.getOwnerList().size() < 2) {
                            cantBeDelete = true;
                        }
                    }
                    if (!cantBeDelete) {
                        for (Team team : ((Owner) role).getTeamList()) {
                            team.getOwnerList().remove(role);
                            team.getRoleHolders().remove(role);
                            String propertiesPath = "log4j.properties";
                            PropertyConfigurator.configure(propertiesPath);
                            systemLoger.info("team closed");

                        }
//                        if (!cantBeDelete) {
//                            iterator.remove();
//                        }
                    }
                    iterator.remove();
                } else if (role instanceof Coach) {
                    ((Coach) role).getTeam().getCoachList().remove(role);
                    ((Coach) role).getTeam().getRoleHolders().remove(role);
                    iterator.remove();

                } else if (role instanceof Manager) {
                    ((Manager) role).getTeam().getManagerList().remove(role);
                    ((Manager) role).getTeam().getRoleHolders().remove(role);
                    iterator.remove();

                } else if (role instanceof Player) {
                    ((Player) role).getTeam().getPlayerList().remove(role);
                    ((Player) role).getTeam().getRoleHolders().remove(role);
                    iterator.remove();

                }
            }

        }
        if (!cantBeDelete) {
            dataManager.deleteUser(user);
        }


    }


}
