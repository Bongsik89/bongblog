package org.smallman.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.smallman.dao.BoardDAO;
import org.smallman.util.FileUtils;
import org.smallman.vo.BoardVO;
import org.smallman.vo.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Resource(name = "fileUtils")
	private FileUtils fileUtils;

	@Inject
	private BoardDAO boardDAO;

	// 게시글 작성
	@Override
	public void write(BoardVO boardVO, MultipartHttpServletRequest httpServletRequest) throws Exception {
		boardDAO.write(boardVO);

		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(boardVO, httpServletRequest);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			boardDAO.insertFile(list.get(i));
		}
	}
	
	// 게시물 목록 조회
	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		return boardDAO.list(scri);
	}
	
	// 게시물 총 갯수
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return boardDAO.listCount(scri);
	}
	
	// 게시물 조회
	@Override
	public BoardVO read(int bno) throws Exception {
		return boardDAO.read(bno);
	}
	
	// 게시물 수정
	@Override
	public void update(BoardVO boardVO) throws Exception {
		boardDAO.update(boardVO);
	}
	
	// 게시물 삭제
	@Override
	public void delete(int bno) throws Exception {
		boardDAO.delete(bno);
	}

}
