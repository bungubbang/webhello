package shop.domain;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer stock;
    private String status;

    public Product() {}

    public Product(String name, Integer price, Integer stock, String status) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", status='" + status + '\'' +
                '}';
    }
}
