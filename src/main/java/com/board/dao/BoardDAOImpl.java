package com.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.common.Pagination;
import com.board.domain.BoardVO;
import com.board.domain.FileUploadVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSession sql;
	 
	private static String namespace = "com.board.mappers.board";
	
	// 게시물 목록
	@Override
	public List<BoardVO> getBoardList(Pagination pagination) throws Exception { 
	 	 return sql.selectList(namespace + ".getBoardList", pagination);
	}
	
	// 게시물 총 개수 조회
	@Override
	public int getBoardListCnt() throws Exception {
		return sql.selectOne(namespace + ".getBoardListCnt");
	}
	
	// 게시글 작성
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".insertBoard", vo);
	}

	// 게시물 조회
	public BoardVO getBoardContent(int bno) throws Exception {
		return sql.selectOne(namespace + ".getBoardContent", bno);
	}

	// 게시글 작성
	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace + ".updateBoard", vo);
	}
		
	// 게시글 삭제
	public void deleteBoard(int bno) throws Exception {
		sql.delete(namespace + ".deleteBoard", bno);
	}
	
	// 게시글 조회수 증가
	public void updateViewCnt(int bno) throws Exception{
		sql.update(namespace + ".updateViewCnt", bno);		
	}
	
	// 게시글 등록 - 파일 첨부
	@Override
	public void insertFile(FileUploadVO vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".insertFile", vo);
	}

	// 게시글 첨부파일 조회
	@Override
	public List<FileUploadVO> getFileListBno(int bno) throws Exception {
		return sql.selectList(namespace + ".selectFileListBno", bno);
	}
	
	// 게시글 첨부파일 상세
	@Override
	public FileUploadVO getFileListIdx(int idx) throws Exception {
		return sql.selectOne(namespace + ".selectFileListIdx", idx);
	}

}