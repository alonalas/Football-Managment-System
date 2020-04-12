package LogicLayer;


import java.util.ArrayList;
import java.util.List;

public class Page {

    private String firstName;
    private String lastName;
    private Team team;
    private List<String> updates;

    public Page(String firstName, String lastName, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        updates = new ArrayList<>();
    }



}
