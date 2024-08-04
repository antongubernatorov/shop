import exceptions.ManagerSaveException;
import managers.Good;
import managers.Manager;
import managers.ShopManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static managers.FileBackendGoodsManager.loadFromFile;

public class Main {

    public static void main(String[] args) throws IOException, ManagerSaveException {
        Manager manager = new Manager();
        File file = new File("src/files", "SavedGoods.csv");
        ShopManager shopManager = new ShopManager();
        loadFromFile(file);
    }
}