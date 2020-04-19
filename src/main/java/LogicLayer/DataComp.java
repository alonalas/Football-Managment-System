package LogicLayer;

import DataLayer.IDataManager;
import DataLayer.dataManager;

import java.io.Serializable;

public class DataComp implements Serializable {

    private static dataManager DManager = new dataManager();
    public static IDataManager  getInstance(){
        return DManager;
    }

    public static void setDataManager(dataManager DManager) {
        DataComp.DManager = DManager;
    }
}
