package Shop;

import java.util.HashMap;

public interface ShopManagerInterface {
    void createCategory(String name);
    void showCategories();
    void showGoodsPerCategory(int categoryId);
    void deleteCategory(int categoryId);

    void addGoodToCategory(Good good, int categoryId);
    Good createGood(String name, double price, double rating);
    void buyGood(int goodId, int userId);
    void deleteGoodFromCategory(int goodId, int categoryId);
    void removeGoodFromBasket(int userId, int goodId);
    void createUser(String login, String password);

    void checkBasket(int userId);
    HashMap<Integer, Good> showAllGoods();
}
