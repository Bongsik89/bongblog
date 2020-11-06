package org.smallman.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smallman.service.BoardService;
import org.smallman.vo.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardService boardService;

	// 게시판 글 작성 화면
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception {
		logger.info("writeView");
	}

	// 게시판 글 작성
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception {
		logger.info("write");

		boardService.write(boardVO);

		return "redirect:/board/list";
	}

	// 게시글 목록 조회
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		logger.info("list입니다.");

		model.addAttribute("list", boardService.list());
		
		return "board/list";
	}

	// 게시글 조회

	@RequestMapping(value = "/board/readView", method = RequestMethod.GET)
	public String read(BoardVO boardVO, Model model) throws Exception {
		logger.info("read");
		model.addAttribute("read", boardService.read(boardVO.getBno()));

		return "board/readView";
	}

	// 게시물 수정뷰
	@RequestMapping(value = "/board/updateView", method = RequestMethod.GET)
	public String updateView(BoardVO boardVO, Model model) throws Exception {
		logger.info("updateView");
		model.addAttribute("update", boardService.read(boardVO.getBno()));
		return "board/updateView";
	}

	// 게시물 수정
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception {
		logger.info("update");
		boardService.update(boardVO);
		return "redirect:/board/list";
	}

	// 게시물 삭제
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO) throws Exception {
		logger.info("delete");
		boardService.delete(boardVO.getBno());
		return "redirect:/board/list";
	}

}
