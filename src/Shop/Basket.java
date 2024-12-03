package Shop;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Good> buyHistory;
    public Basket() {
        this.buyHistory = new ArrayList<Good>();
    }

    public ArrayList<Good> getBasketHistory() {
        return buyHistory;
    }

    public void addGood(Good good){
        buyHistory.add(good);
    }

    public Good getGood(int id){
        return buyHistory.get(id);
    }

    public void deleteGood(int id){
        buyHistory.remove(id);
    }

    public void clearBasket(){
        buyHistory.clear();
    }
}
