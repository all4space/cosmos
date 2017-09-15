package scit.master.planbe.VO;

public class MemberVO {

	private int memberNo;
	private String projectAuthority;
	private int projectNo;
	private int userNo;
	private int canWork;
	private int mustWork;
	
	public MemberVO(){}

	public MemberVO(int memberNo, String projectAuthority, int projectNo, int userNo, int canWork, int mustWork) {
		this.memberNo = memberNo;
		this.projectAuthority = projectAuthority;
		this.projectNo = projectNo;
		this.userNo = userNo;
		this.canWork = canWork;
		this.mustWork = mustWork;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getProjectAuthority() {
		return projectAuthority;
	}

	public void setProjectAuthority(String projectAuthority) {
		this.projectAuthority = projectAuthority;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getCanWork() {
		return canWork;
	}

	public void setCanWork(int canWork) {
		this.canWork = canWork;
	}

	public int getMustWork() {
		return mustWork;
	}

	public void setMustWork(int mustWork) {
		this.mustWork = mustWork;
	}

	@Override
	public String toString() {
		return "MemberVO [memberNo=" + memberNo + ", projectAuthority=" + projectAuthority + ", projectNo=" + projectNo
				+ ", userNo=" + userNo + ", canWork=" + canWork + ", mustWork=" + mustWork + "]";
	}

}
	

	
	
