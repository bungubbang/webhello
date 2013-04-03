package shop.domain;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class ShopAdmin {
    private String id;
    private String password;

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

    @Override
    public String toString() {
        return "ShopAdmin{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
