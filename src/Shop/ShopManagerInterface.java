package Shop;

import java.util.ArrayList;

public interface ShopManagerInterface {
    void createCategory(String name);
    void showCategories();
    void showGoodsPerCategory(int categoryId);
    void deleteCategory(int categoryId);

    void addGoodToCategory(Good good, int categoryId);
    void buyGood(int goodId, int userId);
    void deleteGoodFromCategory(int goodId);

    void addGoodToBasket(int userId, int goodId);
    void removeGoodFromBasket(int userId, int goodId);

    ArrayList<Good> showAllGoods();
}
