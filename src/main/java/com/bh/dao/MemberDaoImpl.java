package com.bh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bh.dto.MemberDto;
@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public void insertMember(MemberDto dto) {
		sqlSession.insert("com.bh.mapper.MemberMapper.insertMember", dto);
	}
	@Override
	public MemberDto loginCheck(String id, String pw) {
		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setPw(pw);
		return sqlSession.selectOne("com.bh.mapper.MemberMapper.selectMember", dto);
	}
	@Override
	public List<MemberDto> allMember() {
		
		return sqlSession.selectList("com.bh.mapper.MemberMapper.allMember");
	}
	@Override
	public void pointUp() {
		sqlSession.update("com.bh.mapper.MemberMapper.pointUp");
	}
	@Override
	public int memberCount() {
		return sqlSession.selectOne("com.bh.mapper.MemberMapper.memberCount");
	}
	

}
