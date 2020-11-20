package org.smallman.service;

import java.util.List;

import javax.inject.Inject;

import org.smallman.dao.ReplyDAO;
import org.smallman.vo.ReplyVO;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDAO replyDAO;

	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		return replyDAO.readReply(bno);
	}

	@Override
	public void writeReply(ReplyVO replyVO) throws Exception {
		replyDAO.writeReply(replyVO);
	}

	@Override
	public void updateReply(ReplyVO replyVO) throws Exception {
		replyDAO.updateReply(replyVO);
	}

	@Override
	public void deleteReply(ReplyVO replyVO) throws Exception {
		replyDAO.deleteReply(replyVO);		
	}

	@Override
	public ReplyVO selectReply(int rno) throws Exception {
		return replyDAO.selectReply(rno);
	}

}
