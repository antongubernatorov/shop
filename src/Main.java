import exceptions.ManagerSaveException;
import managers.*;
import managers.AuthManager.AuthManager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException, ManagerSaveException {
        Manager manager = new Manager();
        FileBackendGoodsManager fileBackendGoodsManager = manager.getFileBackendDefault();

        fileBackendGoodsManager.createCategory("White");
        fileBackendGoodsManager.createCategory("Sport");
        Good good = new Good("Tvorog", 245.0, 4.7, 0);
        Good good1 = new Good("Milk", 245.0, 4.7, 0);
        Good good2 = new Good("Gainer", 245.0, 4.7, 1);
        fileBackendGoodsManager.createGood(good);
        fileBackendGoodsManager.createGood(good1);
        fileBackendGoodsManager.createGood(good2);
        //fileBackendGoodsManager.addGoodToCategory(milk1, 0);
        //fileBackendGoodsManager.addGoodToCategory(tvorog, 0);
        //fileBackendGoodsManager.addGoodToCategory(gainer, 1);
        HashMap<Integer, Good> integerGoodHashMap = fileBackendGoodsManager.showAllGoods();
        System.out.println(integerGoodHashMap);
    }
}