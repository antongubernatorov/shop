import exceptions.ManagerSaveException;
import managers.AuthManager.AuthManager;
import managers.Good;
import managers.Manager;
import managers.ShopManager;
import managers.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static managers.FileBackendGoodsManager.loadFromFile;

public class Main {
    public static void main(String[] args) throws IOException, ManagerSaveException {
        Manager manager = new Manager();
        File file = new File("src/files", "SavedGoods.csv");
        AuthManager authManager = new AuthManager();
        authManager.createUser("Anton126", "Anton123", "Anton123");
        HashMap<Integer, User> users = manager.getDefault().users;
        System.out.println(users);
        Good good = new Good("tvorog", 12.4, 4.6);
        Good good1 = new Good("Milk", 132.4, 4.8);
        manager.getDefault().createGood(good);
        manager.getDefault().createGood(good1);
        manager.getDefault().addGoodToBasket(0, 0);
        manager.getDefault().addGoodToBasket(1, 0);
        manager.getDefault().buyBasket(0);
    }
}