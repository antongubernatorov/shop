package Shop;

import java.util.ArrayList;

public class Good {

    private static ArrayList<Good> goods = new ArrayList<>();
    private final String name;
    private double price;
    private double rating;

    public Good(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        goods.add(this);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public static ArrayList<Good> getGoods(){
        return goods;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
