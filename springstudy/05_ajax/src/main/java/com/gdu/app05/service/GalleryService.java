package com.gdu.app05.service;

import org.springframework.http.ResponseEntity;

public interface GalleryService {
	public ResponseEntity<byte[]> imageDisplay(String path, String filename);// 경로와 이름을 주면 바이트 배열로 반환하겠다
	
}