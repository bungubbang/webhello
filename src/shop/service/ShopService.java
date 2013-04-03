package shop.service;

import shop.domain.Order;
import shop.domain.OrderJoin;
import shop.domain.Product;
import shop.domain.ShopUser;

import java.util.List;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public interface ShopService {

    void createProduct(Product product);
    Product findById(int id);
    List<Product> getAllProduct();
    void modifyProduct(Product product);
    void removeProduct(int id);

    void createOrder(Order order);
    List<OrderJoin> getAllOrder();
    List<OrderJoin> findByUserId(String id);
    Order findByOrderId(int id);
    void modifyOrder(Order order);
    void removeOrder(int id);

    void createShopUser(ShopUser user);
    ShopUser findById(String id);
    void modifyShopUser(ShopUser user);
    void removeShopUser(String id);
}
