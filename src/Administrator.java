import java.util.List;

public class Administrator extends User{
    public Administrator(String email, String password, String userName, System system, List<Role> roles) {
        super(email, password, userName, system, roles);
    }
}
