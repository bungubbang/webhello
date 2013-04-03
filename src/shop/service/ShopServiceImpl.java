package shop.service;

import shop.domain.Order;
import shop.domain.OrderJoin;
import shop.domain.Product;
import shop.domain.ShopUser;
import shop.repository.ShopDBRepository;
import shop.repository.ShopRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class ShopServiceImpl implements ShopService{

    ShopRepository shopRepository = new ShopDBRepository();

    private String URL = "jdbc:postgresql://localhost:5432/study";
    private String USR = "jsp";
    private String PWD = "1234";

    @Override
    public void createProduct(Product product) {
        Connection connection = initConnection();
        try {
            shopRepository.addProduct(product, connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Product findById(int id) {
        Connection connection = initConnection();
        Product product = null;
        try {
            product = shopRepository.findById(id,connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        Connection connection = initConnection();
        List<Product> products = null;
        try {
            products = shopRepository.getAllProduct(connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return products;
    }


    @Override
    public void modifyProduct(Product product) {
        Connection connection = initConnection();
        try {
            shopRepository.updateProduct(product, connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void removeProduct(int id) {
        Connection connection = initConnection();
        try {
            shopRepository.deleteProduct(id, connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void createOrder(Order order) {
        Connection connection = initConnection();
        try {
            shopRepository.addOder(order, connection);

            Product product = shopRepository.findById(order.getProductsid(), connection);
            product.setStock(product.getStock() - order.getAmounts());
            shopRepository.updateProduct(product, connection);

            ShopUser shopUser = shopRepository.findById(order.getShopuserid(), connection);
            shopUser.setMoney(shopUser.getMoney() - order.getAmounts()*product.getPrice());
            shopRepository.updateShopUser(shopUser, connection);

            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<OrderJoin> getAllOrder() {
        Connection connection = initConnection();
        List<OrderJoin> orderJoins  = null;
        try {
            orderJoins = shopRepository.getAllOrder(connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return orderJoins;
    }

    @Override
    public List<OrderJoin> findByUserId(String id) {
        Connection connection = initConnection();
        List<OrderJoin> orderJoins  = null;
        try {
            orderJoins = shopRepository.findByUserId(id, connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return orderJoins;
    }

    @Override
    public Order findByOrderId(int id) {
        Connection connection = initConnection();
        Order order = new Order();
        try {
            order = shopRepository.findOrderById(id, connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return order;
    }

    @Override
    public void modifyOrder(Order order) {
        Connection connection = initConnection();
        try {
            shopRepository.updateOrder(order, connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void removeOrder(int id) {
        Connection connection = initConnection();
        try {
            shopRepository.deleteOrder(id, connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void createShopUser(ShopUser user) {
        Connection connection = initConnection();
        try {
            shopRepository.addShopUser(user, connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public ShopUser findById(String id) {
        Connection connection = initConnection();
        ShopUser shopUser = null;
        try {
            shopUser = shopRepository.findById(id, connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return shopUser;
    }

    @Override
    public void modifyShopUser(ShopUser user) {
        Connection connection = initConnection();
        try {
            shopRepository.updateShopUser(user, connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void removeShopUser(String id) {
        Connection connection = initConnection();
        try {
            shopRepository.deleteShopUser(id, connection);
            connection.commit();
        } catch (SQLException e) {
            rollbackConnection(connection);
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    private Connection initConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USR, PWD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }

    private void rollbackConnection(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void commitConnection(Connection connection) {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
