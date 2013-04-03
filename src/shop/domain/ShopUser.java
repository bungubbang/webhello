package shop.domain;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class ShopUser {
    private String id;
    private String password;
    private Integer money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "ShopUser{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
