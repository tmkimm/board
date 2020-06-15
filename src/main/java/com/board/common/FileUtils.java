package com.board.common;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.board.domain.BoardVO;
import com.board.domain.FileUploadVO;

@Component("fileUtils")
public class FileUtils {
	
	private static final String filePath = "D:\\source\\file\\";
	
	public List<FileUploadVO> parseInsertFileInfo(BoardVO vo, HttpServletRequest request) throws Exception{
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<FileUploadVO> list = new ArrayList<FileUploadVO>();
		FileUploadVO fileUploadVO = null; 
		
		int boardIdx = vo.getBno();
		String boardWriter = vo.getWriter();
		
		File file = new File(filePath);
		if(file.exists() == false){
			file.mkdirs();
		}
		
		while(iterator.hasNext()){
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false){
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = CommonUtils.getRandomString() + originalFileExtension;
				
				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);
				fileUploadVO = new FileUploadVO();
				fileUploadVO.setBoard_idx(boardIdx);
				fileUploadVO.setOriginal_file_name(originalFileName);
				fileUploadVO.setStored_file_name(storedFileName);
				fileUploadVO.setFile_size(multipartFile.getSize());
				fileUploadVO.setCrt_id(boardWriter);
				
				list.add(fileUploadVO);
			}
		} 
		return list;
	}
}