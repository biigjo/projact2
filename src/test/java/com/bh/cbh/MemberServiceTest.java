package com.bh.cbh;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bh.dto.MemberDto;
import com.bh.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberServiceTest {
	@Autowired
	private MemberService memberService;
	
	@Test
	public void testInsert() throws Exception {
		memberService.insertMember(new MemberDto("test","1234","test",0));
	}
	@Test
	public void testSelect() throws Exception {
		MemberDto dto = memberService.loginCheck("admin", "454612");
		System.out.println(dto);
	}
	@Test
	public void testAllMember() throws Exception {
		List<MemberDto> list = memberService.allMember();
		System.out.println(list);
	}
	@Test
	public void testMemberCount() throws Exception {
		int num = memberService.memberCount();
		System.out.println(num);
	}
}
