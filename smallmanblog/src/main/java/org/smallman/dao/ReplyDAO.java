package org.smallman.dao;

import java.util.List;

import org.smallman.vo.ReplyVO;

public interface ReplyDAO {
	
	//댓글 조회
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	//댓글 작성
	public void writeReply(ReplyVO replyVO) throws Exception;
	
	//댓글 수정
	public void updateReply(ReplyVO replyVO) throws Exception;
	
	//댓글 삭제
	public void deleteReply(ReplyVO replyVO) throws Exception;
	
	//선택된 댓글 조회
	public ReplyVO selectReply(int rno) throws Exception;

}
