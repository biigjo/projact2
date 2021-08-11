package com.bh.cbh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bh.dto.MemberDto;
import com.bh.service.MemberService;
import com.bh.util.MyJob;

@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberDto dto;
	@RequestMapping(value = "/")
	public String login() {
		
		return "login";
	}
	@RequestMapping(value = "/join")
	public String join() {
		
		return "join";
	}
	@RequestMapping(value = "/admin")
	public String admin(Model model) {
		List<MemberDto> list = memberService.allMember();
		model.addAttribute("list", list);
		System.out.println(list);
		return "admin";
	}
	@RequestMapping(value = "/start")  // 스케줄러 시작할게요 (= 10초마다 MyJob 실행할게요).
	public String start() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		  // define the job and tie it to our HelloJob class
		  JobDetail job = JobBuilder.newJob(MyJob.class)
		      .withIdentity("job1", "group1")
		      .build();

		  // Trigger the job to run now, and then repeat every 40 seconds
		  Trigger trigger = TriggerBuilder.newTrigger()
		      .withIdentity("trigger1", "group1")
		      .startNow()
		      .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
		      .build();

		  // Tell quartz to schedule the job using our trigger
		  scheduler.scheduleJob(job, trigger);
		  scheduler.start();
		  System.out.println("스케줄러가 시작됨.");
		return "admin";
	}
	
	@RequestMapping(value = "/end")    // 스케줄러 끝낼게요 (= MyJob 그만 할게요).
	public String end() throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.shutdown();
		System.out.println("스케줄러가 종료됨.");
		return "admin";
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpServletResponse response, HttpSession session) throws Exception {
		session.invalidate();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script> alert('로그아웃 되었습니다.'); </script>");
		out.flush();
		return "login";
	}
	@RequestMapping(value = "/loginAction")
	public String loginAction(String id, String pw, HttpSession session,HttpServletResponse response,Model model) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDto dto = memberService.loginCheck(id, pw);
		if(dto!=null) {
			model.addAttribute("dto", dto);
			if(id.equals("admin")) {
				List<MemberDto> list = memberService.allMember();
				model.addAttribute("list", list);
				System.out.println(list);
				return "admin";
			}
			return "main";
		}else {
			out.print("<script> alert('아이디/비밀번호를 다시 확인하세요'); </script>"); 
			out.flush();
			return "login";
		}
	}
	@RequestMapping(value = "/joinAction")
	public String joinAction(String id, String pw, String name, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		memberService.insertMember(new MemberDto(id, pw, name, 0));
		out.print("<script> alert('가입되었습니다. 로그인 해주세요.'); </script>");
		out.flush();
		return "login";
	}
}
