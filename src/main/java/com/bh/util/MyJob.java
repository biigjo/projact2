package com.bh.util;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.bh.dto.MemberDto;
import com.bh.service.MemberService;
import com.bh.service.MemberServiceImpl;

public class MyJob implements Job {
	@Autowired
	MemberDto dto;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext(); 
		MemberService service= ctx.getBean(MemberServiceImpl.class);
		
		service.pointUp();
		int result = 0;
		result = service.memberCount();
		
		System.out.println("JOB�� ����� : " + result +"���� ����Ʈ �ο�(1��)" + new Date(System.currentTimeMillis()));
	}

}
