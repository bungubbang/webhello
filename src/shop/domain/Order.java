package shop.domain;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class Order {
    private Integer id;
    private Integer productsid;
    private String shopuserid;
    private Integer amounts;
    private String comments;
    private String status;

    public Order() {}

    public Order(Integer productsid, String shopuserid, Integer amounts) {
        this.productsid = productsid;
        this.shopuserid = shopuserid;
        this.amounts = amounts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductsid() {
        return productsid;
    }

    public void setProductsid(Integer productsid) {
        this.productsid = productsid;
    }

    public String getShopuserid() {
        return shopuserid;
    }

    public void setShopuserid(String shopuserid) {
        this.shopuserid = shopuserid;
    }

    public Integer getAmounts() {
        return amounts;
    }

    public void setAmounts(Integer amounts) {
        this.amounts = amounts;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productsid=" + productsid +
                ", shopuserid='" + shopuserid + '\'' +
                ", amounts=" + amounts +
                ", comments='" + comments + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
