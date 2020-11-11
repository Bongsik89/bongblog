package org.smallman.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.smallman.vo.BoardVO;
import org.smallman.vo.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;

	// 게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVO);

	}

	@Override
	public List<BoardVO> list(Criteria cri) throws Exception {
		return sqlSession.selectList("boardMapper.list", cri);
	}

	@Override
	public int listCount() throws Exception {
		return sqlSession.selectOne("boardMapper.listCount"); 
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return sqlSession.selectOne("boardMapper.read", bno);
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {
		sqlSession.update("boardMapper.update", boardVO);

	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("boardMapper.delete", bno);
	}

}
