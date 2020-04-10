package LogicLayer;

import java.util.ArrayList;
import java.util.List;

import DataLayer.IDataManager;
import DataLayer.dataManager;
import ServiceLayer.*;

public class User {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    List<Role> roles;
    IDataManager dataManager;

    public User(String email, String password, String firstName, String lastName) {

        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = new ArrayList<Role>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
