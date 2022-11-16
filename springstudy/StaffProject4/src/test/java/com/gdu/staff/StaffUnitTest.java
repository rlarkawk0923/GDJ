package com.gdu.staff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class StaffUnitTest {

	@Autowired
	private StaffMapper staffMapper;
	
	@Before
	public void 테스트이전_사원삽입() {
		StaffDTO staff = new StaffDTO();
		staff.setSno("99999");
		staff.setName("김기획");
		staff.setDept("기획부");
		staff.setSalary(5000);
		assertEquals("사원 등록에 문제가 있습니다.", 1, staffMapper.insertStaff(staff));
	}

	@Test
	public void 사원조회테스트() {
		assertNotNull("사원 검색에 문제가 있습니다.", staffMapper.selectStaffBySno("99999"));
	}

}
