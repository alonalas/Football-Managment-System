package ServiceLayer;

public interface IGuestService {

    void register(String firstName, String lastName, String email, String password);

    void logIn(String lastName, String password);

    void showInformationByCategory(Interest interestIn);

    void searchInformation(Criteria criteria, String query);

    void filterResults(Filter filter, String query);
}
