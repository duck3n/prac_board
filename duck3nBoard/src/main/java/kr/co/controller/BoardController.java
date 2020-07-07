package kr.co.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.service.BoardService;
import kr.co.vo.BoardVO;

@Controller
@RequestMapping("/board") // views 밑에 만들어둔 board 폴더를 인식
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	BoardService service;

	// 게시판 글 작성 화면
	@RequestMapping(value = "/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception {

		logger.info("writeView");
	}

	// 게시판 글 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(BoardVO boardVO) throws Exception {

		service.write(boardVO);
		return "redicect:/board/list";
	}

	// 게시판 글 목록 조회
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest req) throws Exception {

		List<BoardVO> list = service.list();

		req.setAttribute("list", list);
		return "board/list";
	}

	// 게시판 글 개별 상세 조회
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(BoardVO vo, HttpServletRequest req) throws Exception {

		req.setAttribute("read", service.read(vo.getBno()));
		return "board/readView";
	}

	// 게시판 글 수정 화면
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(BoardVO vo, HttpServletRequest req) throws Exception {

		req.setAttribute("update", service.read(vo.getBno()));
		return "board/updateView";
	}

	// 게시판 글 수정
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(BoardVO vo, HttpServletRequest req) throws Exception {

		service.update(vo);
		return "redirect:/board/list";
	}

	// 게시판 글 삭제
	@RequestMapping(value = "/delete")
	public String delete(BoardVO vo, HttpServletRequest req) throws Exception {

		service.delete(vo.getBno());
		return "redirect:/board/list";
	}

}
