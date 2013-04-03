package shop.controller;

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
public class ShopDeleteProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ShopService shopService = new ShopServiceImpl();

        shopService.removeProduct(Integer.parseInt(request.getParameter("id")));

        response.sendRedirect("/shop/adminlist");
    }
}
