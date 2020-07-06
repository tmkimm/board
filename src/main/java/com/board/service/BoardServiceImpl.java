package com.board.service;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.board.common.FileUtils;
import com.board.common.Pagination;
import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;
import com.board.domain.FileUploadVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO dao;
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;

		
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception{
		return dao.getBoardList(pagination);
	}
	
	// 게시물 총 개수 조회
	public int getBoardListCnt() throws Exception {
		return dao.getBoardListCnt();
	}
	
	@Override
	public void insertBoard(BoardVO vo, HttpServletRequest request) throws Exception {
		dao.insertBoard(vo);

		List<FileUploadVO> list = fileUtils.parseInsertFileInfo(vo, request);
		for( int i=0, size=list.size(); i<size; i++) {
			dao.insertFile(list.get(i));
		}		
	}
	
	public BoardVO getBoardContent(int bno) throws Exception {
		dao.updateViewCnt(bno);
		return dao.getBoardContent(bno);
	}
	
	public void updateBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.updateBoard(vo);
	}

	public void deleteBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteBoard(bno);
	}
	
	// 게시글 첨부파일 조회
	@Override
	public List<FileUploadVO> getFileListBno(int bno) throws Exception {
		return dao.getFileListBno(bno);
	}
	
	// 게시글 첨부파일 상세
	@Override
	public FileUploadVO getFileListIdx(int idx) throws Exception {
		return dao.getFileListIdx(idx);
	}
	
}
