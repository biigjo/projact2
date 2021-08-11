package com.bh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bh.dao.MemberDao;
import com.bh.dto.MemberDto;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao dao;
	@Override
	public void insertMember(MemberDto dto) {
		dao.insertMember(dto);
	}
	@Override
	public MemberDto loginCheck(String id, String pw) {
		
		return dao.loginCheck(id, pw);
	}
	@Override
	public List<MemberDto> allMember() {
		
		return dao.allMember();
	}
	@Override
	public void pointUp() {
		dao.pointUp();
	}
	@Override
	public int memberCount() {
		
		return dao.memberCount();
	}



}
