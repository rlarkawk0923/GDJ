package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.StudentDao;

public class StudentRemoveService implements StudentService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		// 없을 때를 대비해서 optional로 쌈
		Optional<String> opt = Optional.ofNullable(request.getParameter("stuNo"));
		int stuNo = Integer.parseInt(opt.orElse("0"));
		
		// DB로 boardNo 보내기(삭제)
		int result = StudentDao.getInstance().deleteStudent(stuNo);
				
		// 삽입 성공 / 실패
		PrintWriter out = response.getWriter();
		if(result > 0 ) {
			
			out.println("<script>");
			out.println("alert('학생 정보가 삭제되었습니다.')");
			out.println("location.href='" + request.getContextPath()+ "/student/list.do'");
			out.println("</script>");
		
		}else {
			
			out.println("<script>");
			out.println("alert('학생정보 삭제를 실패했습니다.')");
			out.println("history.back()"); // history.go(-1)
			out.println("</script>");
		}
		out.close();
		
		return null;
		
	}

}
