package LogicLayer;

import DataLayer.IDataManager;
import DataLayer.DataManager;

import java.io.Serializable;

public class DataComp implements Serializable {

    private static DataManager DManager = new DataManager();
    public static IDataManager  getInstance(){
        return DManager;
    }

    public static void setDataManager(DataManager DManager) {
        DataComp.DManager = DManager;
    }
}
