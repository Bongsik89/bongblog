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

}
