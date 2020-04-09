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
