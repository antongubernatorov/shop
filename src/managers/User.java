package managers;

public class User {
    private String login;
    private String password;
    private Basket basket;

    private final int id;

    public User(int id, String login, String password, Basket basket) {
        this.login = login;
        this.password = password;
        this.basket = basket;
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Basket getBasket() {
        return basket;
    }

    public boolean hasGoodInBasket(int id){
        return basket.getGood(id) != null;
    }

    public void addGoodToBasket(Good good){
        this.basket.addGood(good);
    }

    public void removeGood(int id){
        basket.deleteGood(id);
    }
}
