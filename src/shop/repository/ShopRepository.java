package shop.repository;

import shop.domain.Order;
import shop.domain.OrderJoin;
import shop.domain.Product;
import shop.domain.ShopUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public interface ShopRepository {
    void addProduct(Product product, Connection connection);
    List<Product> getAllProduct(Connection connection);
    Product findById(int id, Connection connection);
    void updateProduct(Product product, Connection connection);
    void deleteProduct(int id, Connection connection);

    void addOder(Order order, Connection connection);
    List<OrderJoin> getAllOrder(Connection connection);
    List<OrderJoin> findByUserId(String id, Connection connection);
    Order findOrderById(int id, Connection connection);
    void updateOrder(Order order, Connection connection);
    void deleteOrder(int id, Connection connection);


    void addShopUser(ShopUser user, Connection connection);
    ShopUser findById(String id, Connection connection);
    void updateShopUser(ShopUser user, Connection connection);
    void deleteShopUser(String id, Connection connection);
}
