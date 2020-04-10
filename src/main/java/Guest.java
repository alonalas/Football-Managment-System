public class Guest {

    private system system;

    public Guest(system system) {
        this.system = system;
    }

    public system getSystem() {
        return system;
    }

    public User signIn(String userName, String password){
        User user = dataManager.getUser(userName, password);
        return user;
    }

}
