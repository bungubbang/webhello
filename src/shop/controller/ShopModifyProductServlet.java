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
public class ShopModifyProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopService shopService = new ShopServiceImpl();

        Product product = shopService.findById(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("product", product);

        RequestDispatcher view = request.getRequestDispatcher("/shop/adminproduct.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ShopService shopService = new ShopServiceImpl();

        Product product = shopService.findById(Integer.valueOf(request.getParameter("id")));
        product.setName(request.getParameter("name"));
        product.setPrice(Integer.valueOf(request.getParameter("price")));
        product.setStock(Integer.valueOf(request.getParameter("stock")));
        product.setStatus(request.getParameter("status"));

        shopService.modifyProduct(product);

        response.sendRedirect("/shop/adminlist");
    }
}
