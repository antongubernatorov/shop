import Shop.Good;
import Shop.ShopManager;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ShopManager shopManager = new ShopManager();
        shopManager.createCategory("Молочка");
        Good good = new Good("Молоко", 75, 4.7);
        Good good1 = new Good("Творог", 89, 4.2);
        shopManager.addGoodToCategory(good, 0);
        shopManager.addGoodToCategory(good1, 0);
        shopManager.showGoodsPerCategory(0);
    }
}