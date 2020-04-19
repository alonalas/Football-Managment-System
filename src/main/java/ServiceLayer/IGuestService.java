package ServiceLayer;

public interface IGuestService {

    boolean register(String firstName, String lastName, String email, String password);

    boolean logIn(String lastName, String password);

    void showInformationByCategory(Interest interestIn);

    void searchInformation(Criteria criteria, String query);

    void filterResults(Filter filter, String query);
}
