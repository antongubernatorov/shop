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
        Good good = new Good("Молоко", 75, 4.7);
        Good good1 = new Good("Творог", 89, 4.2);
        Good good2 = new Good("Курица", 239, 4.9);
        shopManager.addGoodToCategory(good, 0);
        shopManager.addGoodToCategory(good1, 0);
        shopManager.addGoodToCategory(good2, 1);
        shopManager.showCategories();
    }
}