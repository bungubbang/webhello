package shop.controller;

import shop.domain.ShopUser;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class ShopLoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("id")) {
                request.setAttribute("id",cookie.getValue());
            }
        }

        RequestDispatcher view = request.getRequestDispatcher("/shop/login.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ShopService shopService = new ShopServiceImpl();
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("password"));
        if(request.getParameter("id").equals("admin") && request.getParameter("password").equals("1234")) {
            System.out.println("onon");
            response.sendRedirect("/shop/admin");
            return;
        }

        ShopUser shopUser = shopService.findById(request.getParameter("id"));
        if(request.getParameter("rememberId") != null) {
            Cookie cookie = new Cookie("id", request.getParameter("id"));
            cookie.setMaxAge(30 * 24 * 60 * 60); // 한달
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("id", request.getParameter("id"));
            cookie.setMaxAge(0); // 한달
            response.addCookie(cookie);
        }

        if( shopUser.getPassword().equals(request.getParameter("password"))) {
            request.getSession().setAttribute("isLogin", "ok");
            ServletContext servletContext = request.getServletContext();

            // 현재 로그인 사용자 조사
            if( servletContext.getAttribute("loginCount") == null ) {
                // loginCount가 없으면 초기화
                servletContext.setAttribute("loginCount", 0);
            }

            // loginCout를 얻어와서 1을 증가
            servletContext.setAttribute("loginCount", Integer.parseInt(String.valueOf(servletContext.getAttribute("loginCount"))) + 1 );

            request.getSession().setAttribute("userid", request.getParameter("id"));

            response.sendRedirect("/shop/list");
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("isLogin");
        request.getSession().removeAttribute("userid");
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("loginCount", Integer.parseInt(String.valueOf(servletContext.getAttribute("loginCount"))) - 1 );
        response.sendRedirect("/shop/login");
    }

    public static Boolean checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getSession().getAttribute("isLogin") ==  null) {
            response.sendRedirect("/shop/login");
            return false;
        }
        return true;
    }
}
