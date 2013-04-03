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
import java.util.List;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class ShopAdminListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopService shopService = new ShopServiceImpl();

        //1. model에서 데이터 조회
        List<Product> products = shopService.getAllProduct();

        //2. request에 데이터 셋팅
        request.setAttribute("products",products);

        RequestDispatcher view = request.getRequestDispatcher("/shop/adminlist.jsp");
        view.forward(request, response);
    }
}
