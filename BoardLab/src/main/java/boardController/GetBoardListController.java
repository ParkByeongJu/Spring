package boardController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import board.BoardDAO;
import board.BoardVO;

@Controller
public class GetBoardListController {
		
	@Autowired
	BoardDAO boardDAO;
	
//	public void setBoardDAO(BoardDAO boardDAO) {
//		this.boardDAO = boardDAO;
//	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model) {
		
		System.out.println("getBoardList...");
		
		List<BoardVO> boardList = boardDAO.getBoardList();
		model.addAttribute("boardList", boardList); // boardList를 ModelAndView에 추가
		
		return "getBoardList";
	}
	
	@RequestMapping("/getBoard")
	public String getBoard(Model model, Integer seq) {
		
		System.out.println("getBoardList...");
		
		BoardVO board = boardDAO.getBoard(seq);
		model.addAttribute("getboard", board); // boardList를 ModelAndView에 추가
		
		return "getBoard";
	}
	
	@RequestMapping("/insertBoardController")
	public String insertBoardController(Model model, BoardVO vo) {
	    
		System.out.println("insertBoard...");
		
	    
	    boardDAO.insertBoard(vo);
	    
	    return "redirect:/getBoardList";
	}

	@RequestMapping("/insertBoard")
	public String insertBoard(Model model, BoardVO vo) {
		
		return "insertBoard";
	}

}
