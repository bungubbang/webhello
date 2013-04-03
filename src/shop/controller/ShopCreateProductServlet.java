package shop.controller;

import shop.domain.Product;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class ShopCreateProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher view = request.getRequestDispatcher("/shop/product.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ShopService shopService = new ShopServiceImpl();

        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setPrice(Integer.valueOf(request.getParameter("price")));
        product.setStock(Integer.valueOf(request.getParameter("stock")));
        product.setStatus(request.getParameter("status"));

        shopService.createProduct(product);
        response.sendRedirect("/shop/adminlist");
    }
}
