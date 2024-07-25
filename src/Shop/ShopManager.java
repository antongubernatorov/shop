package Shop;

import java.util.ArrayList;
import java.util.HashMap;

import static Shop.Good.getGoods;

public class ShopManager implements ShopManagerInterface {

    HashMap<Integer, Category> categories = new HashMap<>();
    HashMap<User, Basket> usersBasket = new HashMap<>();
    HashMap<Integer, User> users = new HashMap<>();
    private static int categoryId = -1;
    private static int userId = -1;
    private static int goodId = -1;

    public int generateId(int id){
        return ++id;
    }

    public static int getCategoryId() {
        return categoryId;
    }

    public static int getUserId() {
        return userId;
    }

    public static int getGoodId() {
        return goodId;
    }

    @Override
    public void createCategory(String name) {
        categoryId = generateId(getCategoryId());
        Category category = new Category(name);
        categories.put(categoryId, category);
    }

    @Override
    public void showCategories() {
        if(categories.isEmpty()){
            System.out.println("Категорий не существует");
        } else {
            System.out.println(categories);
        }
    }

    @Override
    public void showGoodsPerCategory(int categoryId) {
        if(categories.containsKey(categoryId)){
            Category category = categories.get(categoryId);
            category.showGoods();
        } else {
            System.out.println("Такой категории не существует");
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        if (categories.containsKey(categoryId)){
            categories.remove(categoryId);
        } else {
            System.out.println("Такой категории не существует");
        }
    }

    @Override
    public void addGoodToCategory(Good good, int categoryId) {
        if (categories.containsKey(categoryId)){
            Category category = categories.get(categoryId);
            category.addGood(good);
        } else {
            System.out.println("Такой категории не существует");
        }
    }

    @Override
    public void buyGood(int goodId, int userId) {

    }

    @Override
    public void deleteGoodFromCategory(int goodId) {

    }

    @Override
    public void addGoodToBasket(int userId, int goodId) {

    }

    @Override
    public void removeGoodFromBasket(int userId, int goodId) {

    }

    @Override
    public ArrayList<Good> showAllGoods() {
        return getGoods();
    }
}
