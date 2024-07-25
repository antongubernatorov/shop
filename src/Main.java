import Shop.Good;
import Shop.ShopManager;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ShopManager shopManager = new ShopManager();
        shopManager.createCategory("Молочка");
        shopManager.createCategory("Мясная лавка");
        shopManager.createCategory("Строительные материалы");
        Good milk = shopManager.createGood("Молоко", 75, 4.7);
        Good tvorog = shopManager.createGood("Творог", 89, 4.27);
        Good chicken = shopManager.createGood("Курица", 239, 4.9);
        shopManager.addGoodToCategory(milk, 0);
        shopManager.addGoodToCategory(tvorog, 0);
        shopManager.addGoodToCategory(chicken, 1);
        shopManager.createUser("Anton", "Hello123");
        shopManager.buyGood(1, 0);
        shopManager.buyGood(2, 0);
        shopManager.checkBasket(0);
    }
}