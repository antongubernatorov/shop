package Shop;

import java.util.ArrayList;

public class Basket {
    ArrayList<Good> buyHistory;

    public Basket() {
        this.buyHistory = new ArrayList<Good>();
    }

    public ArrayList<Good> getBuyHistory() {
        return buyHistory;
    }
}
