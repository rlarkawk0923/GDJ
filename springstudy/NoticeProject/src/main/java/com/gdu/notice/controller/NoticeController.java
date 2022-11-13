package com.gdu.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.notice.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/ntc/list")// 폴더이름이랑 매핑 분리한것
	public String list(Model model) { // 모델을 선언해서 노티스서비스에 전달
		noticeService.findAllNotices(model);
		return "notice/list";
	}
	
	@GetMapping("/ntc/write")
	public String write() {
		return "notice/write";
	}
	
	@PostMapping("/ntc/add")
	public void add(HttpServletRequest request, HttpServletResponse response) {
		noticeService.addNotice(request, response); // 서비스가 응답(성공했을때 갈곳 실패했을때 갈곳 ) 만들었기 때문에 리턴 필요없음/ /서비스에 리다이렉트도 됨
	}
	
	@GetMapping("/ntc/detail") // 번호만 넘겨줄때는 리퀘스트 파람이 제일 편함
	public String detail(@RequestParam(value="noticeNo", required=false, defaultValue="0")int noticeNo, Model model){//required 디폴트값 true 그래서 잘못된실행은 400이 뜨는데 디폴트값을 넣어 파라미터값을0을 넣어 400오류가 안뜨고 내용 안보이게함?맞나
		noticeService.findNoticeByNo(noticeNo, model);//셀렉트의 결과를 노티스이름으로 실어서 jsp에서 반환함~
		return "notice/detail";// 업데이트하면 리다리렉트해야하는데 포워딩 했음
	}
	
	@PostMapping("/ntc/modify")
	public void modify(HttpServletRequest request, HttpServletResponse response) {
		noticeService.modifyNotice(request, response);
	}
	
	@PostMapping("/ntc/remove")
	public void remove(HttpServletRequest request, HttpServletResponse response) {
		noticeService.removeNotice(request, response);
	}
	
}