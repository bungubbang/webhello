package myboard.controller;

import myboard.entity.Board;
import myboard.repository.BoardDBRepository;
import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: bungubbang
 * Date: 13. 2. 28.
 * Time: 오후 7:25
 * To change this template use File | Settings | File Templates.
 */
public class BoardDeleteServlet extends HttpServlet {

    BoardRepository boardRepository = BoardDBRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int boardId = Integer.parseInt(request.getParameter("id"));

        boardRepository.deleteBoard(boardId);

        response.sendRedirect("/board/list");
    }
}
