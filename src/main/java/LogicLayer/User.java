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
    IDataManager data;

    public User(String email, String password, String firstName, String lastName, IDataManager data) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = new ArrayList<Role>();
        this.data = data;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void updatePersonalInformation(String firstName, String lastName, String email){
        if (firstName !=null && lastName != null && email != null){
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
    }

    public List<String> getPersonalDetails() {
        List<String> personalDetails = new ArrayList<>();
        personalDetails.add(firstName);
        personalDetails.add(lastName);
        personalDetails.add(email);
        return personalDetails;
    }

}
