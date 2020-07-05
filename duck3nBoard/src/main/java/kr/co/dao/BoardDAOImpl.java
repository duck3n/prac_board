package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.BoardVO;

// @Repository : 일반적으로 DAO에 쓰이며, DB Exception -> DataAccessException으로 변환
// @Inject : 특정 framework에 종속되지 않은 어플리케이션을 구성하기 위한 주입

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession ss;
	
	@Override
	public void write(BoardVO boardVO) throws Exception {
		ss.insert("boardMapper.insert", boardVO);
		
	}

	@Override
	public List<BoardVO> list() throws Exception {
		return ss.selectList("boardMapper.list");
	}

}
