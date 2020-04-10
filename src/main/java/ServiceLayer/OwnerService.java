package ServiceLayer;

import LogicLayer.*;
import java.io.IOException;
import java.util.Date;

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
        String assetType = owner.InsertAssetType();
        User user = owner.getAssetUser();
        if (team != null && valid(assetType) && user!=null) {
            RoleHolder role = control.getRoleHolder(assetType);
            if ( assetType.equals("Stadium") ) {
                control.displayForm(role, true);
                String stadiumName ="";
                stadiumName = owner.fillStadiumName();
                owner.setStadiumToTeam(team,stadiumName);
            }
            else {
                control.displayForm(role, false);
                RoleHolder roleHolder = owner.insertNewAssetType(team, role, user);
                if (roleHolder!= null) {
                    alertOwner(owner.getUser(),control, "new asset was inserted to the team");
                    System.out.println("Asset" + roleHolder.print() + " was inserted successfully");
                }
            }

        }
        else
            throw new IOException("not valid input, please insert valid inputs");
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

    /**
     * assigns an alert to an owner with a corresponding message
     * @param user
     * @param controller
     * @param message
     */
    private void alertOwner(User user, Controller controller, String message) {
        Date date = new Date();
        Alert successfullRegistration = new Alert(user,control,
                message, date );
    }

}

