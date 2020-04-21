package ServiceLayer;

import LogicLayer.*;

import java.lang.reflect.Field;
import LogicLayer.Administrator;
import LogicLayer.Guest;
import LogicLayer.Representitive;
import LogicLayer.User;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.*;
import com.google.gson.*;
import org.json.simple.parser.JSONParser;

public class Controller implements IController{

    private List<Guest> currentGuestsList;
    private Map<Guest,IGuestService> GuestServices;
    private List<User> currentUserList;
    private Map<User,List<IUserService>> UserServices;
    private Representitive representitive;
    private Administrator administrator;
    public static Controller controllerSingleTone ;
    private static String configurationPath = "configurations.json";

    public Controller() {
        try{
            currentGuestsList = new ArrayList<Guest>();
            GuestServices = new HashMap<Guest, IGuestService>();
            currentUserList = new ArrayList<User>();
            UserServices = new HashMap<User, List<IUserService>>();
            FileReader configurationFile = new FileReader(new File(configurationPath));
            initFromFile(configurationFile);
        }catch(IOException IOE){
            System.out.println("## There is no conf. file ##");
            IOE.printStackTrace();
        }
    }

    // TEST
    public Controller(Representitive representitive, Administrator administrator) {
        this.representitive = representitive;
        this.administrator = administrator;
        currentGuestsList = new ArrayList<Guest>();
        GuestServices = new HashMap<Guest, IGuestService>();
        currentUserList = new ArrayList<User>();
        UserServices = new HashMap<User, List<IUserService>>();
        saveData();
    }

    private void initFromFile(FileReader configuration) {
        try{
            Object testObject = new JSONParser().parse(new FileReader("configurations.json"));
            JSONObject controllerJSON = (JSONObject) testObject;
            String admin = (String) controllerJSON.get("admin");
            String rep = (String) controllerJSON.get("rep");
            Gson objects = new Gson();
            this.administrator = objects.fromJson(admin, Administrator.class);
            this.representitive = objects.fromJson(rep, Representitive.class);
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    private void saveData() {
        Gson objects = new Gson();
        String adminJSON = objects.toJson(administrator);
        String repJSON = objects.toJson(representitive);
        JSONObject jsonWriter = new JSONObject();
        jsonWriter.put("admin", adminJSON);
        jsonWriter.put("rep", repJSON);
        try {
            PrintWriter pw = new PrintWriter("configurations.json");
            pw.write(jsonWriter.toJSONString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeUserService(User user) {
        if (user != null && UserServices.containsKey(user)){
            this.UserServices.remove(user);
        }
    }

    /**
     * ID: 1
     * displays the team's asset's details to the screen
     * @param roleHolder
     */
    public void displayForm(RoleHolder roleHolder) {
        if (roleHolder==null)
            System.out.println("Name : String");
        else {
            Field[] declaredFields = roleHolder.getClass().getDeclaredFields();
            for (Field f : declaredFields) {
                System.out.println(f.getName() + " : " + f.getType().getSimpleName());
            }
        }
    }


    public List<Guest> getGuestsList() {
        return currentGuestsList;
    }

    public void setGuestsList(List<Guest> guestsList) {
        this.currentGuestsList = guestsList;
    }

    public List<User> getUserList() {
        return currentUserList;
    }

    public void setUserList(List<User> userList) {
        this.currentUserList = userList;
    }

    public boolean addUser(User user) {
        if (user != null){
            this.currentUserList.add(user);
            UserService userService = new UserService(user,this);
            List<IUserService>services = new ArrayList<>();
            services.add(userService);
            this.UserServices.put(user,services);
            return true;
        }
        return false;
    }

    public Map<User, List<IUserService>> getUserServices() {
        return UserServices;
    }

    public void setUserServices(Map<User, List<IUserService>> userServices) {
        UserServices = userServices;
    }

    public Representitive getRepresentitive() {
        return representitive;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void addGuest(Guest newGuest) {
        if(newGuest == null) return;
        this.currentGuestsList.add(newGuest);
    }

    public void removeGuest(Guest guestToRemove) {
        this.currentGuestsList.remove(guestToRemove);
    }

    public void removeUser(User userToRemove) {
        if (userToRemove != null){
            removeUserService(userToRemove);
            if (currentUserList.contains(userToRemove))
                this.currentUserList.remove(userToRemove);
        }
    }

    @Override
    public void addServicesToUser(User user) {
        for (Role r: user.getRoles()){
            if (r instanceof Fan){
               createFanServiceForUser(user,(Fan)r);
            }else if(r instanceof Player){
                createPlayerServiceForUser(user,(Player)r);
            }else if (r instanceof Coach){
                createCoachServiceForUser(user,(Coach)r);
            }else if (r instanceof Referee){
                createRefereeServiceForUser(user,(Referee)r);
            }else if(r instanceof Owner){
                createOwnerServiceForUser(user,(Owner)r);
            }else if(r instanceof Representitive){
                createRepresentitiveServiceForUser(user,(Representitive)r);
            }else if(r instanceof Manager){
                createManagerServiceForUser(user,(Manager)r);
            }else{
                continue;
            }
        }
    }

    @Override
    public void createFanServiceForUser(User user, Fan fan) {
        if (user != null && fan != null){
            FanService fanService = new FanService(fan, this);
            UserServices.get(user).add(fanService);
        }
    }

    private void createManagerServiceForUser(User user, Manager r) {
        if (user != null && r != null){
            ManagerService managerService = new ManagerService(this);
            UserServices.get(user).add(managerService);
        }
    }


    private void createRepresentitiveServiceForUser(User user, Representitive r) {
        if (user != null && r != null){
            RepresentativeService representativeService = new RepresentativeService(this);
            UserServices.get(user).add(representativeService);
        }
    }


    private void createOwnerServiceForUser(User user, Owner r) {
        if (user != null && r != null){
            OwnerService ownerService = new OwnerService(this);
            UserServices.get(user).add(ownerService);
        }
    }

    private void createRefereeServiceForUser(User user, Referee r) {
        if (user != null && r != null){
            RefereeService refereeService = new RefereeService(r);
            UserServices.get(user).add(refereeService);
        }
    }

    private void createPlayerServiceForUser(User user, Player r) {
        if (user != null && r != null){
            PlayerService playerService = new PlayerService(r, this);
            UserServices.get(user).add(playerService);
        }
    }

    private void createCoachServiceForUser(User user, Coach r) {
        if (user != null && r != null){
            CoachService coachService = new CoachService(r,this);
            UserServices.get(user).add(coachService);
        }
    }
}
