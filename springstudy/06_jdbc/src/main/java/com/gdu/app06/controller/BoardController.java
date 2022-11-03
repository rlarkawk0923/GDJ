package com.gdu.app06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app06.domain.BoardDTO;
import com.gdu.app06.service.BoardService;

@Controller
public class BoardController {
	
	
	// Controller는 Service를 사용합니다.
	@Autowired  // 컨테이너에 생성된 bean 중에서 BoardService 타입의 bean을 가져오시오.
	private BoardService boardService;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("brd/list")
	public String list(Model model) {  // Model은 forward할 속성(Attribute)을 저장할 때 사용한다.
		model.addAttribute("boards", boardService.findAllBoards());
		return "board/list";  // board 폴더의 list.jsp로 forward
	}
	
	@GetMapping("brd/write")
	public String write() {
		return "board/write";//board 폴더의 write.jsp로 forward
	}
	
	@PostMapping("brd/add")
	public String add(BoardDTO board) {
		boardService.saveBoard(board);//saveBoard()로 부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/list";
	}
	
	@GetMapping("brd/detail") // 상세보기는 겟매핑으로만함
	public String detail(@RequestParam(value="board_no", required = false, defaultValue ="0")int board_no
										, Model model) {
		model.addAttribute("board", boardService.findBoardByNo(board_no)); // 보드라는 이름으로 포워딩함
		return "board/detail";
	}
	
	@PostMapping("brd/edit")
	public String edit(int board_no
						, Model model) {
		model.addAttribute("board", boardService.findBoardByNo(board_no));
		return "board/edit"; // board 폴더의 edit.jsp로 forward
	}
	
	@PostMapping("brd/modify")
	public String modify(BoardDTO board) {
		boardService.modifyBoard(board); //modifyBoard()로 부터 0/1이 반환되지만 처리하지 않았다.
		return "redirect:/brd/detail?board_no=" + board.getBoard_no(); // 수정후에 리다이렉트해 상세보기는 보드넘버 붙여서 보내야됨 넘버없으면 0으로
	}
	
	@PostMapping("brd/remove")
	public String remove(int board_no) {
		boardService.removeBoard(board_no);
		return "redirect:/brd/list";
	}
	
	
	
}