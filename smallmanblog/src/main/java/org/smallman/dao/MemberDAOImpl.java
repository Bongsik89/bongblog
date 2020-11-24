package org.smallman.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.smallman.vo.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public void register(MemberVO memberVO) throws Exception {
		sqlSession.insert("memberMapper.register", memberVO);
	}

	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		return sqlSession.selectOne("memberMapper.login", memberVO);
	}

	@Override
	public void memberUpdate(MemberVO memberVO) throws Exception {
		sqlSession.update("memberMapper.memberUpdate", memberVO);	
	}

	@Override
	public void memberDelete(MemberVO memberVO) throws Exception {
		sqlSession.delete("memberMapper.memberDelete", memberVO);
	}

	@Override
	public int passChk(MemberVO memberVO) throws Exception {
		int result = sqlSession.selectOne("memberMapper.passChk", memberVO);
		return result;
	}

	@Override
	public int idChk(MemberVO memberVO) throws Exception {
		int result = sqlSession.selectOne("memberMapper.idChk", memberVO);
		return result;
	}

}
