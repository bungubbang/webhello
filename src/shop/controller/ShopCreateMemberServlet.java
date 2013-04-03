package shop.controller;

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
public class ShopCreateMemberServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/shop/join.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ShopService shopService = new ShopServiceImpl();

        ShopUser shopUser = new ShopUser();
        shopUser.setId(request.getParameter("id"));
        shopUser.setMoney(Integer.valueOf(request.getParameter("money")));
        shopUser.setPassword(request.getParameter("password"));

        shopService.createShopUser(shopUser);

        response.sendRedirect("/shop/list");
    }
}
