package com.gdu.app14.controller;

<<<<<<< HEAD
<<<<<<< HEAD
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
=======
=======
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
>>>>>>> b5c256ee0d2db4290b9c7253b62aa7d62dbb3fab
=======
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
>>>>>>> b5c256ee0d2db4290b9c7253b62aa7d62dbb3fab
=======
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app14.service.UploadService;

@Controller
public class UploadController {

	@Autowired
	private UploadService uploadService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	@GetMapping("upload/list")
=======
	@GetMapping("/upload/list")
>>>>>>> b5c256ee0d2db4290b9c7253b62aa7d62dbb3fab
=======
	@GetMapping("/upload/list")
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
	public String list(Model model) {
		model.addAttribute("uploadList", uploadService.getUploadList());
		return "upload/list";
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	@GetMapping("upload/write")
=======
	@GetMapping("/upload/write")
>>>>>>> b5c256ee0d2db4290b9c7253b62aa7d62dbb3fab
=======
	@GetMapping("/upload/write")
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
	public String write() {
		return "upload/write";
	}
	
	@PostMapping("/upload/add")
	public void add(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		uploadService.save(multipartRequest, response);
	}
<<<<<<< HEAD
<<<<<<< HEAD
}
=======
=======
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
	
	@GetMapping("/upload/detail")
	public String detail(@RequestParam(value="uploadNo", required=false, defaultValue="0") int uploadNo, Model model) {
		uploadService.getUploadByNo(uploadNo, model);
		return "upload/detail";
	}
	
	@ResponseBody
	@GetMapping("/upload/download")
	public ResponseEntity<Resource> download(@RequestHeader("User-Agent") String userAgent, @RequestParam("attachNo") int attachNo) {
		return uploadService.download(userAgent, attachNo);
	}
	
	@ResponseBody
	@GetMapping("/upload/downloadAll")
	public ResponseEntity<Resource> downloadAll(@RequestHeader("User-Agent") String userAgent, @RequestParam("uploadNo") int uploadNo) {
		return uploadService.downloadAll(userAgent, uploadNo);
	}
	
	@PostMapping("/upload/edit")
	public String edit(@RequestParam("uploadNo") int uploadNo, Model model) {
		uploadService.getUploadByNo(uploadNo, model);
		return "upload/edit";
	}
	
	@PostMapping("/upload/modify")
	public void modify(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		uploadService.modifyUpload(multipartRequest, response);
	}
	
	@GetMapping("/upload/attach/remove")
	public String attachRemove(@RequestParam("uploadNo") int uploadNo, @RequestParam("attachNo") int attachNo) {
		uploadService.removeAttachByAttachNo(attachNo);
		return "redirect:/upload/detail?uploadNo=" + uploadNo;
	}
	
	@PostMapping("/upload/remove")
	public void remove(HttpServletRequest request, HttpServletResponse response) {
		uploadService.removeUpload(request, response);
	}
	
<<<<<<< HEAD
}
>>>>>>> b5c256ee0d2db4290b9c7253b62aa7d62dbb3fab
=======
}
>>>>>>> e10b0b09a89f6ea94d3b2bfe88d4ae35480531c0
