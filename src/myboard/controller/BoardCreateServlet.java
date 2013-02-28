package myboard.controller;

import myboard.entity.Board;
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
 * Time: 오후 7:25
 * To change this template use File | Settings | File Templates.
 */
public class BoardCreateServlet extends HttpServlet {

    BoardRepository boardRepository = BoardMemoryRepository.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Board board = new Board();
        board.setWriter(request.getParameter("writer"));
        board.setPw(request.getParameter("password"));
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));

        boardRepository.addBoard(board);

        response.sendRedirect("/board/list");
    }
}
