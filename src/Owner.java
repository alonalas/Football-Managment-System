import java.util.List;

public class Owner extends RoleHolder {

    private String name;
    private List<Team> teamList;

    public Owner(User user, String name, List<Team> teamList) {
        super(user);
        this.name = name;
        this.teamList = teamList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}
