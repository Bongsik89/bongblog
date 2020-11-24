package org.smallman.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import org.smallman.dao.MemberDAO;
import org.smallman.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDAO;

	@Override
	public void register(MemberVO memberVO) throws Exception {
		memberDAO.register(memberVO);
	}

	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		return memberDAO.login(memberVO);
	}

	@Override
	public void memberUpdate(MemberVO memberVO) throws Exception {
		memberDAO.memberUpdate(memberVO);
	}

	@Override
	public void memberDelete(MemberVO memberVO) throws Exception {
		memberDAO.memberDelete(memberVO);
	}

	@Override
	public int passChk(MemberVO memberVO) throws Exception {
		int result = memberDAO.passChk(memberVO);
		return result;
	}

	@Override
	public int idChk(MemberVO memberVO) throws Exception {
		int result = memberDAO.idChk(memberVO);
		return result;
	}

}
