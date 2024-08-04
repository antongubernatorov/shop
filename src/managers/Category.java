package managers;

import java.util.ArrayList;
import java.util.Objects;

public class Category {
    private final String name;
    private ArrayList<Good> goods;

    public Category(String name) {
        this.name = name;
        this.goods = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Good> getGoods() {
        return goods;
    }

    public void addGood(Good good) {
        this.goods.add(good);
    }

    public void showGoods(){
        for(Good el : goods){
            System.out.println(el);
        }
    }

    public void deleteGood(Good good){
        goods.remove(good);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) && Objects.equals(goods, category.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, goods);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", goods=" + goods +
                '}';
    }
}
