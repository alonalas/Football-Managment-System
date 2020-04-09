package LogicLayer;

public class Fan extends Role{

    private String name;

    public Fan(User user, String name) {
        super(user);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
