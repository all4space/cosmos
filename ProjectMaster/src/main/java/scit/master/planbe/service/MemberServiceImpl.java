package scit.master.planbe.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scit.master.planbe.VO.MemberVO;
import scit.master.planbe.VO.UsersVO;
import scit.master.planbe.dao.MemberDAOImpl;


@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDAOImpl dao;
	
	@Override
	public void ManagerAdd(MemberVO memberVo) {
		dao.ManagerAdd(memberVo);
		
	}
	
	@Override
	public void MemberAdd(MemberVO memberVo) {
		dao.MemberAdd(memberVo);
	}

	@Override
	public MemberVO getMemberNo(String userId) {
		return dao.getMemberNo(userId);
		}

	@Override
	public ArrayList<Integer> getProjectNo(String userId) {
		return dao.getProjectNo(userId);
	}
}
