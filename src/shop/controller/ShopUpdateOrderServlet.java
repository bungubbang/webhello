package shop.controller;

import shop.domain.Order;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class ShopUpdateOrderServlet extends HttpServlet {

    ShopService shopService = new ShopServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameterMap());
        ShopService shopService = new ShopServiceImpl();

        if(!ShopLoginServlet.checkLogin(request, response)) {
            return;
        }

        Order order = shopService.findByOrderId(Integer.parseInt(request.getParameter("id")));
        order.setStatus(request.getParameter("status"));
        System.out.println("order = " + order);
        shopService.modifyOrder(order);

        response.sendRedirect("/shop/order");
    }
}
