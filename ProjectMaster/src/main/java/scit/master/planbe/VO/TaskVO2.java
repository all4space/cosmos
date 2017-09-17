package scit.master.planbe.VO;

public class TaskVO2 { //This class is adding the task of userName. 

	private int projectNo;
	private int memberNo;
	private int taskNo;
	private String taskName;
	private String userName;
	private int totalTime;
	private int doneTime;
	
	public TaskVO2(int projectNo, int memberNo, int taskNo, String taskName, String userName, int totalTime,
			int doneTime) {
		this.projectNo = projectNo;
		this.memberNo = memberNo;
		this.taskNo = taskNo;
		this.taskName = taskName;
		this.userName = userName;
		this.totalTime = totalTime;
		this.doneTime = doneTime;
	}

	@Override
	public String toString() {
		return "TaskVO2 [projectNo=" + projectNo + ", memberNo=" + memberNo + ", taskNo=" + taskNo + ", taskName="
				+ taskName + ", userName=" + userName + ", totalTime=" + totalTime + ", doneTime=" + doneTime + "]";
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(int taskNo) {
		this.taskNo = taskNo;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public int getDoneTime() {
		return doneTime;
	}

	public void setDoneTime(int doneTime) {
		this.doneTime = doneTime;
	}

}
	
