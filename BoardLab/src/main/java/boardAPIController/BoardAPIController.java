package boardAPIController;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import board.BoardDAO;
import board.BoardVO;

@RestController
public class BoardAPIController {
	
	@Autowired
	BoardDAO boardDAO;
	

	//@RequestMapping(value = "/getBoardListAPI", method=RequestMethod.GET)
	@GetMapping("/api/news")
	public List<BoardVO> getBoardListAPI() {
		
		System.out.println("getBoardList...");
		
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		return boardList;
	} 
	
	@GetMapping("/api/news/{seq}")
    public BoardVO getBoardAPI(@PathVariable("seq") Integer seq) {
        // 조회수 증가
        boardDAO.increaseHitCount(seq);

        BoardVO board = boardDAO.getBoard(seq);
        
            return board;
    }
	
	@PostMapping("/api/news")
    public String createBoardAPI(BoardVO board) {
	    
	    BoardVO createdBoard = boardDAO.insertBoard(board);
        if (createdBoard != null) {
            return "getBoardListAPI";
        } else {
            return "Failed to create board";
        }
    }
	
	@PostMapping("/api/news/{seq}")
    public String updateBoardAPI(BoardVO board, @PathVariable("seq") Integer seq ) {
	    board.setSeq(seq);
	    int result =  boardDAO.updateBoard(board);
        if (result > 0) {
            return "getBoardListAPI";
        } else {
            return "Failed to create board";
        }
    }
	
	// API: 글 삭제
   @DeleteMapping("/api/news/{seq}")
   public String deleteBoardAPI(@PathVariable("seq") Integer seq) throws ClassNotFoundException, SQLException {

       int result = boardDAO.deleteBoard(seq);

       if (result == 1) {
            return "{\"message\": \"게시글이 삭제되었습니다.\"}";
        } else {
            return "{\"message\": \"게시글 삭제에 실패하였습니다. 잠시 후 다시 시도해주세요.\"}";
        }
    }
	
}
