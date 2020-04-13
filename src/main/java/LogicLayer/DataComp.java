package LogicLayer;

import DataLayer.IDataManager;
import DataLayer.dataManager;

public class DataComp {
    private static dataManager DManager = new dataManager();
    public static IDataManager  getInstance(){
        return DManager;
    }
}
