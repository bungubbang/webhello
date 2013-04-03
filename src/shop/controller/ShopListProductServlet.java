package shop.controller;

import myboard.controller.BoardLoginServlet;
import myboard.entity.Board;
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
import java.util.List;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class ShopListProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopService shopService = new ShopServiceImpl();

        if(!ShopLoginServlet.checkLogin(request, response)) {
            return;
        }

        // 현재 접속자수 조사
        request.setAttribute("loginCount",request.getServletContext().getAttribute("loginCount"));

        //1. model에서 데이터 조회
        List<Product> products = shopService.getAllProduct();

        //2. request에 데이터 셋팅
        request.setAttribute("products",products);

        ShopUser shopUser = shopService.findById(String.valueOf(request.getSession().getAttribute("userid")));

        request.setAttribute("user", shopUser);

        RequestDispatcher view = request.getRequestDispatcher("/shop/list.jsp");
        view.forward(request, response);
    }
}
