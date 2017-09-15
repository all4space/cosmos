package scit.master.planbe.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import scit.master.planbe.VO.UsersVO;

public interface UsersService {
	public void join(UsersVO vo); // 회원 가입
    public boolean idCheck(String userId); // ID 중복 체크
    public boolean ctoCheck(UsersVO vo); // CTO 중복 체크 
	public void login(UsersVO vo, HttpSession session); // 로그인
	public boolean delete(UsersVO vo); // 회원 탈퇴 
	public int getUserNo(String userId);
	public ArrayList<UsersVO> getUserVo(String groupName);
	public UsersVO getUserInfo(int userNo);
}
