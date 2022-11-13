package com.gdu.app05.service;

import java.io.File;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;

public class GalleryServiceImpl implements GalleryService {
	
	@Override
	public ResponseEntity<byte[]> imageDisplay(String path, String filename){
		File file = new File(path,filename);
		
		ResponseEntity<byte[]>entity = null;
		
		try {
			String contentType = Files.probeContentType(file.toPath());
			//System.out.println(contentType); sysout은 남아있으면 서버성능 잡아먹음
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", contentType);
			entity = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	

}