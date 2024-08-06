package managers;

import exceptions.ManagerSaveException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ShopManager implements ShopManagerInterface {

    public static HashMap<Integer, Category> categories = new HashMap<>();
    public HashMap<Integer, User> users = new HashMap<>();
    public static HashMap<Integer, Good> goods = new HashMap<>();
    HashMap<Integer, Basket> baskets = new HashMap<>();

    public static ArrayList<Integer> goodIds = new ArrayList<>();
    private static int categoryId = -1;
    public static int goodId = -1;

    public int generateId(int id){
        return ++id;
    }

    public static int getCategoryId() {
        return categoryId;
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
    public ArrayList<Good> showGoodsPerCategory(int categoryId) {
        if(categories.containsKey(categoryId)){
            Category category = categories.get(categoryId);
            ArrayList<Good> goods1 = category.showGoods();
            return goods1;
        } else {
            System.out.println("Такой категории не существует");
            return null;
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
    public void createGood(Good good) throws ManagerSaveException {
        goodId = generateId(getGoodId());
        good.setId(goodId);
        goodIds.add(goodId);
        goods.put(goodId, good);
    }

    //добавить сортировку
    //добавить функционал по добавлению в корзину
    @Override
    public void addGoodToBasket(int goodId, int userId) {
        Good good = goods.get(goodId);
        if (good == null){
            System.out.println("Такого товара не существует");
        }
        if(!users.containsKey(userId)){
            System.out.println("Такого пользователя не существует");
        }
        User user = users.get(userId);
        user.addGoodToBasket(good);
        baskets.put(userId, user.getBasket());
    }

    @Override
    public void buyBasket(int userId) {
        User user = users.get(userId);
        if(user == null){
            System.out.println("Такого пользователя не существует");
        } else{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("Дата: dd.MM.yyyy HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.println(localDateTime.format(dateTimeFormatter));
            System.out.println(" ");
            double total = 0;
            Basket basket = user.getBasket();
            System.out.println("Продукты       Цена");
            System.out.println("--------------------------------------");
            for(Good el : basket.getBasketHistory()){
                System.out.printf("%-11s %7.2f%n", el.getName(), el.getPrice());
                total += el.getPrice();
            }
            System.out.println("--------------------------------------");
            System.out.printf("%-12s %.2f","Итого:", total);
            basket.clearBasket();
        }
    }

    //нужно 100% отрефакторить
    @Override
    public void deleteGoodFromCategory(int goodId, int categoryId) {
        if(!categories.containsKey(categoryId)){
            System.out.println("Такой категории не существует");
        } else {
            Category category = categories.get(categoryId);
            ArrayList<Good> goodList = category.getGoods();
            for(Good el:goodList){
                if(el.getId() == goodId){
                    category.deleteGood(goods.get(goodId));
                }
            }
        }
    }

    @Override
    public void removeGoodFromBasket(int userId, int goodId) {
        if(!users.containsKey(userId)){
            System.out.println("Такого пользователя не существует");
        } else {
            User user = users.get(userId);
            if(user.hasGoodInBasket(goodId)){
                user.removeGood(goodId);
            } else {
                System.out.println("Товара в корзине нет");
            }
        }
    }

    @Override
    public Basket checkBasket(int userId) {
        Basket basket = null;
        if(!users.containsKey(userId)){
            System.out.println("Такого пользователя не существует");
        } else {
            User user = users.get(userId);
            basket = user.getBasket();
            System.out.println(basket.getBasketHistory());
        }
        return basket;
    }

    @Override
    public HashMap<Integer, Good> showAllGoods() {
        return goods;
    }

    public Map<Integer, Good> sortGoodsByPrice() {
        Map<Integer, Good> sortedGoods = new TreeMap<>(goods);
        System.out.println(sortedGoods);
        return sortedGoods;
    }
}
