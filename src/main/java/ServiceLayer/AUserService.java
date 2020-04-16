package ServiceLayer;

import LogicLayer.Page;

import java.io.IOException;
import java.util.List;

public abstract class AUserService implements IUserService{

    public void addPages(List<Page> newPages) throws IOException {
        throw new IOException("not possible");
    }

    public void logOut() throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public void showPersonalInformation() throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public void editPersonalInformation(String firstName, String lastName, String email) throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public void retrieveHistory() throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public void searchInformation(String name) throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public void searchInformation(Interest interested) throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public void searchInformationByKeyWord(String query) throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public void report(String description) throws IOException {
        throw new IOException("not possible");
    }

    @Override
    public void addUpdate(String update) throws IOException {
        throw new IOException("not possible");
    }
}
