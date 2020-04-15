package ServiceLayer;
import LogicLayer.Page;

import java.io.IOException;
import java.util.List;

public interface IUserService {

    void addPages(List<Page> newPages) throws IOException;

    void logOut() throws IOException;

    List<String> showPersonalInformation() throws IOException;

    void editPersonalInformation(String firstName, String lastName, String email) throws IOException;

    List<String> retrieveHistory() throws IOException;

    void searchInformation(String name) throws IOException;

    void searchInformation(Interest interested) throws IOException;

    void searchInformationByKeyWord(String query) throws IOException;

    void report(String description) throws IOException;

    void addUpdate(String update) throws IOException;

}
