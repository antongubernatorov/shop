package managers;

import java.util.Objects;

public class Good implements Comparable<Good>{

    private final String name;
    private double price;
    private double rating;
    private int id;
    private int categoryId = -1;

    public Good(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Good( String name, double price, double rating, int categoryId) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.categoryId = categoryId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return  id +
                "," + name +
                "," + price +
                "," + rating +
                "," + categoryId;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Double.compare(price, good.price) == 0 && Double.compare(rating, good.rating) == 0 && id == good.id && Objects.equals(name, good.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, rating, id);
    }

    @Override
    public int compareTo(Good o) {
        return (int) (this.price - o.price);
    }

}
