package com.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.board.common.Pagination;
import com.board.domain.BoardVO;
import com.board.domain.FileUploadVO;

public interface BoardService {
	//게시물 조회
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception;
	
	// 게시물 총 개수 조회
	public int getBoardListCnt() throws Exception;
	
	// 게시물 작성
	public void insertBoard(BoardVO vo, HttpServletRequest request) throws Exception;
	
	//게시물 상세
	public BoardVO getBoardContent(int bno) throws Exception;
	
	//게시물 수정
	public void updateBoard(BoardVO vo) throws Exception;	
	
	//게시물 삭제
	public void deleteBoard(int bno) throws Exception;

	//첨부파일 리스트
	public List<FileUploadVO> getFileListBno(int bno) throws Exception;
	
	//첨부파일 상세
	public FileUploadVO getFileListIdx(int idx) throws Exception;
}
