package myboard.repository;

import myboard.entity.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * User: HolyEyE
 * Date: 13. 2. 27. Time: 오후 5:22
 */
public class BoardMemoryRepository implements BoardRepository {

    private static int keyStore = 0;

    private static BoardMemoryRepository instance = new BoardMemoryRepository();

    private List<Board> boards = new ArrayList<Board>();

    public static BoardMemoryRepository getInstance() {
        return instance;
    }

    private BoardMemoryRepository() {

        Board board = new Board();
        board.setId(generateId());
        board.setTitle("title");
        board.setWriter("작성자");
        board.setContent("좋은 글 입니다.");
        board.setPw("pw");

        boards.add(board);
        boards.add(new Board(generateId(), "title2","작성자2","pw","content입니다."));
    }

    @Override
    public List<Board> getBoards() {
        return boards;
    }

    @Override
    public Board FindById(int id) {
        for(Board board : boards) {
            if(id == board.getId()) {
                return board;
            }
        }
        return null;
    }

    @Override
    public void addBoard(Board board) {

        int newId = generateId();
        board.setId(newId);
        boards.add(board);
    }

    @Override
    public void modifyBoard(Board ModifiedBoard) {
        for(Board board : boards) {
            if(board.getId() == ModifiedBoard.getId()) {
                board.setWriter(ModifiedBoard.getWriter());
                board.setTitle(ModifiedBoard.getTitle());
                board.setContent(ModifiedBoard.getContent());
            }
        }
    }

    @Override
    public void deleteBoard(int id) {
        // TODO 좋은 방법 없을까??;;
        for (int i = 0; i < boards.size(); i++) {
            if(boards.get(i).getId() == id) {
                boards.remove(i);
            }
        }
    }

    private synchronized int generateId() {
        return keyStore++;
    }

}
