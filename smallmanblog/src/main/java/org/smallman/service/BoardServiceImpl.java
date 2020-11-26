package org.smallman.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
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
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardVO read(int bno) throws Exception {
		boardDAO.boardHit(bno);
		return boardDAO.read(bno);
	}

	@Override
	public void update(BoardVO boardVO, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest)
			throws Exception {

		boardDAO.update(boardVO);

		List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(boardVO, files, fileNames, mpRequest);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			tempMap = list.get(i);
			if (tempMap.get("IS_NEW").equals("Y")) {
				boardDAO.insertFile(tempMap);
			} else {
				boardDAO.updateFile(tempMap);
			}
		}
	}

	// 게시물 삭제
	@Override
	public void delete(int bno) throws Exception {
		boardDAO.delete(bno);
	}

	@Override
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		return boardDAO.selectFileList(bno);
	}

	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return boardDAO.selectFileInfo(map);
	}

}
