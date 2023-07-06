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
    
//    public void setDataSource(DataSource dataSource) {
//    	this.dataSource = dataSource;
//    }

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
		
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);
		board = template.queryForObject(sql,  new BeanPropertyRowMapper<>(BoardVO.class), seq);
		
    	
		return board;
    }
    
    public BoardVO insertBoard(BoardVO vo) {
        String sql = "INSERT INTO b_board (seq, title, writer, content) "
                   + "VALUES (board_seq.NEXTVAL, ?, ?, ?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, vo.getTitle(), vo.getWriter(), vo.getContent());

        return vo;
    }
    	
    }




