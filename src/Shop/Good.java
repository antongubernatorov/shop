package Shop;

import java.util.ArrayList;

public class Good {

    private final String name;
    private double price;
    private double rating;
    private final int id;

    public Good(int id, String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.id = id;
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

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }

    public int getId() {
        return id;
    }
}
