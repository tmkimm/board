package com.board.domain;

import java.util.Date;

public class BoardVO {

	/*
CREATE TABLE BOARD_LIST(bno            INT NOT NULL
                      , title          VARCHAR2(100) NOT NULL
                      , content        VARCHAR2(4000) NOT NULL
                      , writer         VARCHAR2(100) NOT NULL
                      , regDate       DATE DEFAULT SYSDATE
                      , viewCnt       INT DEFAULT 0
                      , PRIMARY KEY(BNO)
                       );	
	 */
	private int bno;
    
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int viewCnt;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
}
