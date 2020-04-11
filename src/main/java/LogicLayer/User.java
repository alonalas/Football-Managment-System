package LogicLayer;

import java.util.List;
import ServiceLayer.*;

public class User {

    private String email;
    private String password;
    private String userName;
    private IController system;
    List<Role> roles;

    public User(String email, String password, String userName, IController system, List<Role> roles) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.system = system;
        this.roles = roles;
    }

    /**
     * id: User@2
     * add new Role
     * @param role
     * @return true if added successfully , else if already exists
     */
    public boolean addRole(Role role){
        if(!roles.contains(role)) {
            roles.add(role);
            return true;
        }
        return false ;
    }

    /**
     * id: User@3
     * remove Role
     * @param role
     * @return Object that been removed , null if object removed before
     */
    public Object removeRole(Role role){
        if(roles.contains(role)) {
            return roles.remove(role);
        }
        return null ;
    }

    /**
     * id: User@
     * find RefereeRoleIfExist  , else return null
     * @return
     */
    public Referee ifUserRoleIncludeReferee(){
        for(Role r : roles){
            if(r instanceof Referee){
                return (Referee)r ;
            }
        }
        return null;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public IController getSystem() {
        return system;
    }

    public void setSystem(IController system) {
        this.system = system;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
