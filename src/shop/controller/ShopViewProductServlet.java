package shop.controller;

import shop.domain.Product;
import shop.domain.ShopUser;
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
public class ShopViewProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopService shopService = new ShopServiceImpl();

        if(!ShopLoginServlet.checkLogin(request, response)) {
            return;
        }

        Integer productId = Integer.valueOf(request.getParameter("id"));
        Product product = shopService.findById(productId);
        request.setAttribute("product",product);

        ShopUser shopUser = shopService.findById(String.valueOf(request.getSession().getAttribute("userid")));
        request.setAttribute("user", shopUser);

        RequestDispatcher view = request.getRequestDispatcher("/shop/view.jsp");
        view.forward(request, response);
    }
}
