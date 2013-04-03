package shop.repository;

import shop.domain.Order;
import shop.domain.OrderJoin;
import shop.domain.Product;
import shop.domain.ShopUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class ShopDBRepository implements ShopRepository {

    private static ShopDBRepository instance = new ShopDBRepository();

    public static ShopDBRepository getInstance() {
        return instance;
    }

    @Override
    public void addProduct(Product product, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products(name, price, stock, status) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getStock());
            preparedStatement.setString(4, product.getStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProduct(Connection connection){
        List<Product> products = new ArrayList<Product>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from products order by id desc");
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));
                product.setStock(resultSet.getInt("stock"));
                product.setStatus(resultSet.getString("status"));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(int id, Connection connection) {
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products where id=? order by id desc");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getInt("price"));
            product.setStock(resultSet.getInt("stock"));
            product.setStatus(resultSet.getString("status"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void updateProduct(Product product, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE products SET name=?, price=?, stock=?, status=? WHERE id=?");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getStock());
            preparedStatement.setString(4, product.getStatus());
            preparedStatement.setInt(5, product.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteProduct(int id, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products WHERE id=?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOder(Order order, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders(productsid, shopuserid, amounts, comments, status) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, order.getProductsid());
            preparedStatement.setString(2, order.getShopuserid());
            preparedStatement.setInt(3, order.getAmounts());
            preparedStatement.setString(4, order.getComments());
            preparedStatement.setString(5, order.getStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<OrderJoin> getAllOrder(Connection connection) {
        List<OrderJoin> orderJoins = new ArrayList<OrderJoin>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT o.id, p.name, p.price, o.amounts, o.shopuserid, o.comments, o.status FROM orders o LEFT OUTER JOIN products p ON o.productsid = p.id order by id desc");
            while (resultSet.next()) {
                OrderJoin orderJoin = new OrderJoin();
                orderJoin.setId(resultSet.getInt("id"));
                orderJoin.setName(resultSet.getString("name"));
                orderJoin.setAmounts(resultSet.getInt("amounts"));
                orderJoin.setPrice(resultSet.getInt("price"));
                orderJoin.setUserId(resultSet.getString("shopuserid"));
                orderJoin.setComments(resultSet.getString("comments"));
                orderJoin.setStatus(resultSet.getString("status"));

                orderJoins.add(orderJoin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderJoins;
    }

    @Override
    public List<OrderJoin> findByUserId(String id, Connection connection) {
        List<OrderJoin> orderJoins = new ArrayList<OrderJoin>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT o.id, p.name, p.price, o.amounts, o.shopuserid, o.comments, o.status FROM orders o LEFT OUTER JOIN products p ON o.productsid = p.id AND o.shopuserid = ? order by id desc");
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OrderJoin orderJoin = new OrderJoin();
                orderJoin.setId(resultSet.getInt("id"));
                orderJoin.setName(resultSet.getString("name"));
                orderJoin.setAmounts(resultSet.getInt("amounts"));
                orderJoin.setPrice(resultSet.getInt("price"));
                orderJoin.setUserId(resultSet.getString("shopuserid"));
                orderJoin.setComments(resultSet.getString("comments"));
                orderJoin.setStatus(resultSet.getString("status"));

                orderJoins.add(orderJoin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderJoins;
    }

    @Override
    public Order findOrderById(int id, Connection connection) {
        Order order = new Order();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where id=? order by id desc");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            order.setId(resultSet.getInt("id"));
            order.setProductsid(resultSet.getInt("productsid"));
            order.setShopuserid(resultSet.getString("shopuserid"));
            order.setAmounts(resultSet.getInt("amounts"));
            order.setComments(resultSet.getString("comments"));
            order.setStatus(resultSet.getString("status"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void updateOrder(Order order, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orders SET productsid=?, shopuserid=?, amounts=?, id=?, comments=?, status=? WHERE id=?");
            preparedStatement.setInt(1, order.getProductsid());
            preparedStatement.setString(2, order.getShopuserid());
            preparedStatement.setInt(3, order.getAmounts());
            preparedStatement.setInt(4, order.getId());
            preparedStatement.setString(5, order.getComments());
            preparedStatement.setString(6, order.getStatus());
            preparedStatement.setInt(7, order.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int id, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE id=?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addShopUser(ShopUser user, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO shopuser(id, password, money) VALUES (?, ?, ?)");
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getMoney());

            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ShopUser findById(String id, Connection connection) {
        ShopUser shopUser = new ShopUser();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, password, money FROM shopuser WHERE id=?");
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            shopUser.setId(resultSet.getString("id"));
            shopUser.setPassword(resultSet.getString("password"));
            shopUser.setMoney(resultSet.getInt("money"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shopUser;
    }

    @Override
    public void updateShopUser(ShopUser user, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE shopuser SET id=?, password=?, money=? WHERE id=?");
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getMoney());
            preparedStatement.setString(4, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteShopUser(String id, Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM shopuser WHERE id=?");
            preparedStatement.setString(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
