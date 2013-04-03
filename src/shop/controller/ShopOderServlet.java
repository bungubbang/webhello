package shop.controller;

import shop.domain.Order;
import shop.domain.OrderJoin;
import shop.domain.ShopUser;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class ShopOderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ShopService shopService = new ShopServiceImpl();

        if(!ShopLoginServlet.checkLogin(request, response)) {
            return;
        }

        ShopUser shopUser = shopService.findById(String.valueOf(request.getSession().getAttribute("userid")));
        request.setAttribute("user", shopUser);

        List<OrderJoin> orderJoins;
        RequestDispatcher view;
        if(request.getParameter("id") == null) {
            orderJoins = shopService.getAllOrder();
            request.setAttribute("orderJoins", orderJoins);
            view = request.getRequestDispatcher("/shop/adminOrder.jsp");
        } else {
            orderJoins = shopService.findByUserId(request.getParameter("id"));
            request.setAttribute("orderJoins", orderJoins);
            view = request.getRequestDispatcher("/shop/order.jsp");
        }
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameterMap());
        ShopService shopService = new ShopServiceImpl();

        if(!ShopLoginServlet.checkLogin(request, response)) {
            return;
        }

        Order order = new Order();
        order.setProductsid(Integer.valueOf(request.getParameter("productId")));
        order.setShopuserid(request.getParameter("userId"));
        order.setAmounts(Integer.valueOf(request.getParameter("amounts")));
        order.setComments(request.getParameter("comments"));
        order.setStatus(request.getParameter("status"));

        shopService.createOrder(order);

        response.sendRedirect("/shop/order?id=" + String.valueOf(request.getSession().getAttribute("userid")));
    }
}
