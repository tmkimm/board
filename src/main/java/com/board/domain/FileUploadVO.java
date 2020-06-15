package com.board.domain;

import java.util.Date;

public class FileUploadVO {

	/*
CREATE TABLE FILE_UPLOAD(IDX            NUMBER
                       , BOARD_IDX      NUMBER NOT NULL
                       , ORIGINAL_FILE_NAME VARCHAR2(260 BYTE) NOT NULL
                       , STORED_FILE_NAME VARCHAR2(36 BYTE) NOT NULL
                       , FILE_SIZE      NUMBER
                       , CRT_DATE       DATE DEFAULT SYSDATE NOT NULL
                       , CRT_ID         VARCHAR2(30 BYTE) NOT NULL
                       , DEL_GB         VARCHAR2(1 BYTE) DEFAULT 'N' NOT NULL
                       , PRIMARY KEY(IDX)
                        );
	 */
	private int idx;
    
	private int board_idx;
	private String original_file_name;
	private String stored_file_name;
	private long file_size;
	private Date crt_date;
	private String crt_id;
	private String del_gb;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getOriginal_file_name() {
		return original_file_name;
	}
	public void setOriginal_file_name(String original_file_name) {
		this.original_file_name = original_file_name;
	}
	public String getStored_file_name() {
		return stored_file_name;
	}
	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
	public Date getCrt_date() {
		return crt_date;
	}
	public void setCrt_date(Date crt_date) {
		this.crt_date = crt_date;
	}
	public String getCrt_id() {
		return crt_id;
	}
	public void setCrt_id(String crt_id) {
		this.crt_id = crt_id;
	}
	public String getDel_gb() {
		return del_gb;
	}
	public void setDel_gb(String del_gb) {
		this.del_gb = del_gb;
	}	
	@Override
	public String toString() {
		return "FileUploadVO [idx=" + idx + ", board_idx=" + board_idx + ", original_file_name=" + original_file_name
				+ ", stored_file_name=" + stored_file_name + ", file_size=" + file_size + ", crt_date=" + crt_date
				+ ", crt_id=" + crt_id + ", del_gb=" + del_gb + "]";
	}
}
