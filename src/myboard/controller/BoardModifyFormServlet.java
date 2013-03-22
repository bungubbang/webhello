package myboard.controller;

import myboard.entity.Board;
import myboard.repository.BoardDBRepository;
import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bungubbang
 * Date: 13. 2. 28.
 * Time: 오후 7:26
 * To change this template use File | Settings | File Templates.
 */
public class BoardModifyFormServlet extends HttpServlet {

    BoardRepository boardRepository = BoardDBRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(!BoardLoginServlet.checkLogin(request,response)) {
            return;
        }

        int boardId = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("board", boardRepository.FindById(boardId));

        RequestDispatcher view = request.getRequestDispatcher("/board/boardModify.jsp");
        view.forward(request, response);
    }
}
