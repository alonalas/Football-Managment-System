public class Representitive extends Role {

    private String name;

    public Representitive(User user, String name) {
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
