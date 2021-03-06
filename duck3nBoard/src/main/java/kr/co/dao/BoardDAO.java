package kr.co.dao;

import java.util.List;

import kr.co.vo.BoardVO;

public interface BoardDAO {
	
	public void write(BoardVO boardVO) throws Exception;
	
	public List<BoardVO> list() throws Exception;
	
	public BoardVO read(int bno) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public void update(BoardVO boardVO) throws Exception;
}
