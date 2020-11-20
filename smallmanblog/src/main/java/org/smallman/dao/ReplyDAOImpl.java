package org.smallman.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.smallman.vo.ReplyVO;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		return sqlSession.selectList("replyMapper.readReply", bno);
	}

	@Override
	public void writeReply(ReplyVO replyVO) throws Exception {
		sqlSession.insert("replyMapper.writeReply", replyVO);
		
	}

	@Override
	public void updateReply(ReplyVO replyVO) throws Exception {
		sqlSession.update("replyMapper.updateReply", replyVO);
		
	}

	@Override
	public void deleteReply(ReplyVO replyVO) throws Exception {
		sqlSession.delete("replyMapper.deleteReply", replyVO);		
	}

	@Override
	public ReplyVO selectReply(int rno) throws Exception {		
		return sqlSession.selectOne("replyMapper.selectReply", rno);
	}

}
