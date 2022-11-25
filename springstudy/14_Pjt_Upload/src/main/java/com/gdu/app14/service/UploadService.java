package com.gdu.app14.service;

import java.util.List;

<<<<<<< HEAD
<<<<<<< HEAD
import javax.servlet.http.HttpServletResponse;

=======
=======
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
<<<<<<< HEAD
>>>>>>> b5c256ee0d2db4290b9c7253b62aa7d62dbb3fab
=======
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app14.domain.UploadDTO;

public interface UploadService {
	public List<UploadDTO> getUploadList();
	public void save(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
<<<<<<< HEAD
<<<<<<< HEAD

}
=======
=======
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
	public void getUploadByNo(int uploadNo, Model model);
	public ResponseEntity<Resource> download(String userAgent, int attachNo);
	public ResponseEntity<Resource> downloadAll(String userAgent, int uploadNo);
	public void modifyUpload(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
	public void removeAttachByAttachNo(int attachNo);
	public void removeUpload(HttpServletRequest multipartRequest, HttpServletResponse response);
<<<<<<< HEAD
}
>>>>>>> b5c256ee0d2db4290b9c7253b62aa7d62dbb3fab
=======
}
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
