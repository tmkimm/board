package com.board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.common.Pagination;
import com.board.domain.BoardVO;
import com.board.domain.FileUploadVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController{

	@Inject
	BoardService service;

	@RequestMapping(value = "/getBoardList", method = RequestMethod.GET)
	public void getBoardList(Model model, @RequestParam(required = false, defaultValue = "1") int page
									    , @RequestParam(required = false, defaultValue = "1") int range) throws Exception {
		// 전체 게시물 개수
		int listCnt = service.getBoardListCnt();
		// 페이징 객체
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);
		
		// 게시판 리스트
		List<BoardVO> list = service.getBoardList(pagination);
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("list", list);
		
	}

	// 게시물 작성
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public void getInsertBoard() throws Exception {
	}
	
	// 게시물 작성
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String insertBoard(BoardVO vo, HttpServletRequest request) throws Exception {
		service.insertBoard(vo, request);
		
		return "redirect:/board/getBoardList";
	}
	
	// 게시물 상세 조회
	@RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
	public void getBoardContent(@RequestParam("bno") int bno, Model model) throws Exception {
		
		// 상세 정보
		BoardVO vo = service.getBoardContent(bno);
		
		// 첨부 파일 리스트
		List<FileUploadVO> fileUpload = service.getFileListBno(bno);
		
		model.addAttribute("view", vo);
		model.addAttribute("fileUpload", fileUpload);
	}
	
	// 게시물 수정 조회
	@RequestMapping(value = "/updateBoard", method = RequestMethod.GET)
	public void getBoardUpdate(@RequestParam("bno") int bno, Model model) throws Exception {

		BoardVO vo = service.getBoardContent(bno);
		model.addAttribute("view", vo);	
	}

	// 게시물 수정 완료
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public String updateBoard(BoardVO vo) throws Exception {
		service.updateBoard(vo);
		
		return "redirect:/board/getBoardList";
	}

	// 게시물 삭제
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
	public String postDelete(@RequestParam("bno") int bno) throws Exception {

		service.deleteBoard(bno);
		
		return "redirect:/board/getBoardList";
	}
	
	// 게시물 작성
	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @RequestParam("idx") int idx) throws Exception {
		
		// 파일 정보
		FileUploadVO vo = service.getFileListIdx(idx);		

		String storedFileName = vo.getStored_file_name();
		String originalFileName = vo.getOriginal_file_name();
		byte fileByte[] = FileUtils.readFileToByteArray(new File("D:\\source\\file\\"+storedFileName));
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();

		
	}
}