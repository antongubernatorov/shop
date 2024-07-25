package Shop;

import java.util.ArrayList;

public interface ShopManagerInterface {
    void createCategory(String name);
    ArrayList<Category> showCategories(int categoryId);
    void showGoodsPerCategory(int categoryId);
    void deleteCategory(int categoryId);

    void addGoodToCategory(Good good, int categoryId);
    void buyGood(int goodId);
    void deleteGoodFromCategory(int goodId);

    void addGoodToBasket(int userId, int goodId);
    void removeGoodFromBasket(int userId, int goodId);

}
