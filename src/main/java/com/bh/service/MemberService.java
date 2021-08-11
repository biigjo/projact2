package com.bh.service;

import java.util.List;

import com.bh.dto.MemberDto;

public interface MemberService {
	void insertMember(MemberDto dto);
	MemberDto loginCheck(String id, String pw);
	List<MemberDto> allMember();
	void pointUp();
	int memberCount();
}
