package service;

<<<<<<< HEAD
=======
import java.util.Optional;

>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
<<<<<<< HEAD
=======
import repository.StudentDao;
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5

public class StudentDetailService implements StudentService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
<<<<<<< HEAD
		return null;
=======
		// 요청 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("stuNo"));
		int stuNo = Integer.parseInt(opt.orElse("0"));
		
		// stuNo에 해당하는 Student를 request에 저장하기
		request.setAttribute("student", StudentDao.getInstance().selectStudentsByNO(stuNo));
		
		// student/detail.jsp로 포워딩
		return new ActionForward("/student/detail.jsp", false);
		
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
	}

}
