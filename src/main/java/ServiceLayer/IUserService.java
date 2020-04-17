package ServiceLayer;
import LogicLayer.Page;

import java.io.IOException;
import java.util.List;

public interface IUserService {

    void addPages(List<Page> newPages) throws IOException;

    void logOut() throws IOException;

    void showPersonalInformation() throws IOException;

    void editPersonalInformation(String firstName, String lastName, String email) throws IOException;

    void retrieveHistory(Criteria criteria) throws IOException;

    public void searchInformation(Criteria criteria, String query) throws IOException;

    void report(String description) throws IOException;

    void addUpdate(String update) throws IOException;

}
