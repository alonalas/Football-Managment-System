package ServiceLayer;

import LogicLayer.*;

import java.io.IOException;

public class OwnerService extends AUserService{

    public OwnerService(Controller control) {
        super(control);
    }

    public void validateNewAssetType(Owner owner, String teamName,
                                     String email, String userName) throws IOException {
        Team team = owner.getTeam(teamName);
        if (team == null)
            throw new IOException("The chosen team does not exist, please choose a valid team");
        if (!(email.equals("X") && userName.equals("X"))) { // not a stadium
            User user = owner.getAssetUser(userName, email);
            if (user == null)
                throw new IOException("The chosen user does not exist, please insert valid inputs");
        }
    }

    public void insertNewManager(Owner owner, String teamName, String managerName, String userName, String email) {
        owner.nominateManager(owner.getTeam(teamName),managerName,userName,email);
    }

    public void insertNewStadium(Owner owner, String teamName, String stadiumName) {
        owner.insertNewStadium(owner.getTeam(teamName),stadiumName);
    }

    public void insertNewPlayer(Owner owner, String teamName, String name, String position, int day ,
                                int month, int year ,String userName, String email) throws IOException {
        validateBirthDate(day,month,year);
        owner.insertNewPlayer(owner.getTeam(teamName),name,position,day,month,year,userName,email);

    }

    public void insertNewCoach(Owner owner, String teamName, String name, String qualification, String job,String userName,
                               String email) {
        owner.insertNewCoach(owner.getTeam(teamName),name,qualification,job,userName,email);
    }

    /**
     * validates the ranges of a player's birthday
     * @param day
     * @param month
     * @param year
     * @throws IOException
     */
    private void validateBirthDate(int day, int month, int year) throws IOException {

        if (!(year > 1900 && year < 2020 )) {
            throw new IOException("Year of birth is illegal, please insert a year between " +
                    "1900 and 2020");
        }
        if (!(month > 0 && month < 13 )) {
            throw new IOException("Month is illegal, please insert valid month between 1 and 12");
        }
        if (!(day > 0 && day < 32 )) {
            throw new IOException("Day is illegal, please insert valid day between 1 and 31");
        }

    }
}

