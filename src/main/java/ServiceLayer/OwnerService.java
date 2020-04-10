package ServiceLayer;

import LogicLayer.*;
import java.io.IOException;

public class OwnerService extends AUserService{

    public OwnerService(Controller control) {
        super(control);
    }

    /**
     * adds new asset to the owner's team (player/coach/manager/stadium)
     * @param owner
     * @throws IOException
     */
    @Override
    public void insertNewAssetType(Owner owner) throws IOException {
        Team team = owner.selectTeam();
        if (team == null)
            throw new IOException("The chosen team does not exist, please choose a valid team");
        String assetType = owner.InsertAssetType();
        if (!valid(assetType))
            throw new IOException("Incorrect asset type, please insert a valid input");
        User user = owner.getAssetUser();
        if (user == null)
            throw new IOException("The chosen user does not exist, please insert valid inputs");

        RoleHolder role = control.getRoleHolder(assetType);
        if ( assetType.equals("Stadium") ) {
            control.displayForm(role, true);
            String stadiumName ="";
            stadiumName = owner.fillStadiumName();
            owner.setStadiumToTeam(team,stadiumName);
            System.out.println("Stadium " + assetType + "was inserted to team " + team + "successfully");
        }
        else {
            control.displayForm(role, false);
            RoleHolder roleHolder = owner.insertNewAssetType(team, role, user);
            if (roleHolder!= null)
                System.out.println("Role holder " + roleHolder.showRoleDetails() + " was inserted successfully");
        }
    }

    /**
     * check if user's input is a valid option
     * @param assetType
     * @return true if assetType is a valid input, else otherwise
     */
    private boolean valid(String assetType) {
        if (assetType.equals("Player") || assetType.equals("Manager") || assetType.equals("Stadium")  || assetType.equals("Coach"))
                return true;
        return false;
    }
}

