package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class BoardDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    @Autowired
    private DataSource dataSource;
    

    // 문의글 전체 보기
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        String sql = "SELECT * from b_board ORDER BY seq DESC";

        
        //spring JDBC
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        boardList = template.query(sql, new BeanPropertyRowMapper<>(BoardVO.class));

        return boardList;
    }
    
    public BoardVO getBoard(int seq) {
    	
    	BoardVO board = null;
		String sql = "select * from b_board where seq = ?";
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		board = template.queryForObject(sql,  new BeanPropertyRowMapper<>(BoardVO.class), seq);
    	
		return board;
    }
    
    public void increaseHitCount(int seq) {
        String sql = "UPDATE b_board SET hit = hit + 1 WHERE seq = ?";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, seq);
    }
    
    public BoardVO insertBoard(BoardVO vo) {
        String sql = "INSERT INTO b_board (seq, title, writer, content) "
                   + "VALUES (board_seq.NEXTVAL, ?, ?, ?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, vo.getTitle(), vo.getWriter(), vo.getContent());

        return vo;
    }
    
    public int updateBoard(BoardVO vo) {
		int result;
    	String sql = "UPDATE b_board SET title = ?, content = ? where seq = ?";
    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    	result = jdbcTemplate.update(sql, vo.getTitle(), vo.getContent(), vo.getSeq());
    	
    	return result;
    }
    
 // 글 삭제
    public int deleteBoard(int seq) {
       int result = 0;
       StringBuilder sql = new StringBuilder();
       sql.append(" DELETE FROM b_board");
       sql.append(" WHERE seq = ?");
       
       // spring JDBC
       JdbcTemplate template = new JdbcTemplate();
       template.setDataSource(dataSource);
       result = template.update(sql.toString(), seq);
       return result;
    }
    	
    }




