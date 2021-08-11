package com.bh.cbh;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bh.dao.MemberDao;
import com.bh.dto.MemberDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDaoTest {
	@Autowired
	private MemberDao dao;
	
	@Test
	public void testInsert() throws Exception {
		dao.insertMember(new MemberDto("admin","454612","°ü¸®ÀÚ",0));
	}
	@Test
	public void testSelect() throws Exception {
		MemberDto list = dao.loginCheck("biigjo", "454612");
		System.out.println(list);
	}
	@Test
	public void testAllMember() throws Exception {
		List<MemberDto> list = dao.allMember();
		System.out.println(list);
	}
	@Test
	public void testPointUp() throws Exception {
		dao.pointUp();
	}
	@Test
	public void testMemberCount() throws Exception {
		int num = dao.memberCount();
		System.out.println(num);
	}
}
