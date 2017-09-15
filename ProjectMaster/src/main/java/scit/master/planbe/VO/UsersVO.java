package scit.master.planbe.VO;

public class UsersVO {
	private int userNo;
	private String userId;
	private String userName;
	private String userPwd;
	private String groupName;
	private String Authority;
	
	public UsersVO(){}
	
	public UsersVO(int userNo, String userId, String userName, String userPwd, String groupName, String authority) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.groupName = groupName;
		Authority = authority;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getAuthority() {
		return Authority;
	}

	public void setAuthority(String authority) {
		Authority = authority;
	}

	@Override
	public String toString() {
		return "UsersVO [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd
				+ ", groupName=" + groupName + ", Authority=" + Authority + "]";
	}
	
}
