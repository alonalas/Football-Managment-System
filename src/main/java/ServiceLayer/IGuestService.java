package ServiceLayer;

public interface IGuestService {

    void register(String firstName, String lastName, String email, String password);

    void logIn(String lastName, String password);

    void searchInformation(String name);

    void searchInformation(Interest interested);

    void searchInformationByKeyWord(String query);
}
