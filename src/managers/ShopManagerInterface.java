package managers;

import exceptions.ManagerSaveException;

import java.util.HashMap;

public interface ShopManagerInterface {
    void createCategory(String name);
    void showCategories();
    void showGoodsPerCategory(int categoryId);
    void deleteCategory(int categoryId);

    void addGoodToCategory(Good good, int categoryId);
    void createGood(Good good) throws ManagerSaveException;
    void addGoodToBasket(int goodId, int userId);
    void buyBasket(int userId);
    void deleteGoodFromCategory(int goodId, int categoryId);
    void removeGoodFromBasket(int userId, int goodId);
    void checkBasket(int userId);
    HashMap<Integer, Good> showAllGoods();
}
