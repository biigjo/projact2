package com.bh.dao;

import java.util.List;

import com.bh.dto.MemberDto;

public interface MemberDao {
	void insertMember(MemberDto dto);
	MemberDto loginCheck(String id, String pw);
	List<MemberDto> allMember();
	void pointUp();
	int memberCount();
}
