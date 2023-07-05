package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

public class BoardDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // 문의글 전체 보기
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT *");
        sql.append("  from b_board");
        sql.append(" ORDER BY seq DESC");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(sql.toString());

            rs = stmt.executeQuery();

            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setHit(rs.getInt("HIT"));
                boardList.add(board);
                
                System.out.println(boardList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boardList;
    }

//public class BoardDAO {
//	
//	private Connection conn;
//	private PreparedStatement stmt;
//	private ResultSet rs;
//	
//	private static String BOARD_LIST = "select * from b_board";
//	
//	public List<BoardVO> getBoardList(){
//		List<BoardVO> boardList = new ArrayList<BoardVO>();
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_LIST);
//			rs = stmt.executeQuery();
//			while(rs.next()) {
//				BoardVO board = new BoardVO();
//				board.setSeq(rs.getInt("SEQ"));
//				board.setTitle(rs.getString("TITLE"));
//				board.setWriter(rs.getString("WRITER"));
//				board.setContent(rs.getString("CONTENT"));
//				board.setRegDate(rs.getDate("REGDATE"));
//				board.setHit(rs.getInt("HIT"));
//				boardList.add(board);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(rs, stmt, conn);
//		}
//		return boardList;
//	}

}
