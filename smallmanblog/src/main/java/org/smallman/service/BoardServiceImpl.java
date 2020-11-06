package org.smallman.service;

import java.util.List;

import javax.inject.Inject;

import org.smallman.dao.BoardDAO;
import org.smallman.vo.BoardVO;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;

	@Override
	public void write(BoardVO boardVO) throws Exception {
		boardDAO.write(boardVO);

	}
	
	@Override
	public List<BoardVO> list() throws Exception {
		return boardDAO.list();
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return boardDAO.read(bno);
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {
		boardDAO.update(boardVO);
	}

	@Override
	public void delete(int bno) throws Exception {
		boardDAO.delete(bno);
	}

}
