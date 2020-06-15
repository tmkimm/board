package com.board.dao;

import java.util.List;

import com.board.common.Pagination;
import com.board.domain.BoardVO;
import com.board.domain.FileUploadVO;

public interface BoardDAO {
	
	// 게시물 조회
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception;
	
	// 게시물 총 개수 조회
	public int getBoardListCnt() throws Exception;
	
	// 게시물 작성
	public void insertBoard(BoardVO vo) throws Exception;
	
	// 게시물 상세
	public BoardVO getBoardContent(int bno) throws Exception;
	
	// 게시물 수정
	public void updateBoard(BoardVO vo) throws Exception;
	
	// 게시물 삭제
	public void deleteBoard(int bno) throws Exception;

	// 게시물 조회수 증가
	public void updateViewCnt(int bno) throws Exception;

	public void insertFile(FileUploadVO vo) throws Exception;

	public List<FileUploadVO> getFileListBno(int bno) throws Exception;

	public FileUploadVO getFileListIdx(int idx) throws Exception;

}