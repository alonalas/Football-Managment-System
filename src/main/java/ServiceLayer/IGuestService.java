package ServiceLayer;

enum Interest {
    Players,
    Teams,
    Leagues,
    Games,
    Seasons,
    Coaches,
    Owners,
    Managers
}

public interface IGuestService {

    void register(String firstName, String lastName, String email, String password);

    void logIn(String lastName, String password);

    public void searchInformation(String name);

    public void searchInformation(Interest interested);
}
