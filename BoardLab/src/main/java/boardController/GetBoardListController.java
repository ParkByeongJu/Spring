package boardController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.BoardDAO;
import board.BoardVO;

public class GetBoardListController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 게시글 목록을 가져오는 비즈니스 로직을 호출
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList();
		request.setAttribute("boardList", boardList);
		System.out.println(boardList);
		
		ModelAndView mv = new ModelAndView();
//		mv.addObject("boardList", boardList); // boardList를 ModelAndView에 추가
		mv.setViewName("getBoardList");
		return mv;
	}

}
