package shop.domain;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class OrderJoin {
    private Integer id;
    private String name;
    private Integer price;
    private Integer amounts;
    private String userId;
    private String comments;
    private String status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        return "OrderJoin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amounts=" + amounts +
                ", userId='" + userId + '\'' +
                ", comments='" + comments + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
