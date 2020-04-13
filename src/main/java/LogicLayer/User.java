package LogicLayer;

import java.util.ArrayList;
import java.util.List;

import DataLayer.IDataManager;
import ServiceLayer.*;

public class User {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    List<Role> roles;
    IDataManager dataManager;
    private IController system;

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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * USE CASE - 3.1
     * logOut from system
     */
    public void logOut() {
        system.removeUser(this);
        system.removeUserService( this);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void updatePersonalInformation(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public List<String> getPersonalDetails() {
        List<String> personalDetails = new ArrayList<>();
        personalDetails.add(firstName);
        personalDetails.add(firstName);
        personalDetails.add(firstName);
        return personalDetails;
    }

    public IController getSystem() {
        return system;
    }
}
