package ServiceLayer;
import LogicLayer.*;

import java.io.IOException;
import java.util.List;

public interface IUserService {

    void addPage(Page newPage) throws IOException;
    List<User> getSystemUsers() ;

    void addPages(List<Page> newPages) throws IOException;

    void logOut() throws IOException;

    List<String> showPersonalInformation() throws IOException;

    boolean editPersonalInformation(String firstName, String lastName, String email) throws IOException;

    List<String> retrieveHistory(Criteria criteria) throws IOException;

    public void searchInformation(Criteria criteria, String query) throws IOException;

    void report(String description) throws IOException;

    void addUpdate(String update) throws IOException;

}
