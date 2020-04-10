package LogicLayer;

import java.util.LinkedList;
import java.util.List;
import ServiceLayer.*;

public class User {

    private String email;
    private String password;
    private String userName;
    //private IController system;
    private List<Role> roles;

    public User(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.roles = new LinkedList<>();
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRole(Role role){
        this.roles.add(role);
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
