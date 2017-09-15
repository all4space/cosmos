package scit.master.planbe.VO;

public class TaskVO {

	private int projectNo;
	private int memberNo;
	private int taskNo;
	private String taskName;
	private String taskContent;
	private String taskPriority;
	private String taskStatus;
	private String startDate;
	private String dueDate;
	private int totalTime;
	private int doneTime;
	
	public TaskVO(){}

	public TaskVO(int projectNo, int memberNo, int taskNo, String taskName, String taskContent,
			String taskPriority, String taskStatus, String startDate, String dueDate, int totalTime, int doneTime) {
		super();
		this.projectNo = projectNo;
		this.memberNo = memberNo;
		this.taskNo = taskNo;
		this.taskName = taskName;
		this.taskContent = taskContent;
		this.taskPriority = taskPriority;
		this.taskStatus = taskStatus;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.totalTime = totalTime;
		this.doneTime = doneTime;
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

	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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

	@Override
	public String toString() {
		return "TaskVO [projectNo=" + projectNo + ", memberNo=" + memberNo + ", taskNo=" + taskNo + ", taskName="
				+ taskName + ", taskContent=" + taskContent + ", taskPriority=" + taskPriority + ", taskStatus="
				+ taskStatus + ", startDate=" + startDate + ", dueDate=" + dueDate + ", totalTime=" + totalTime
				+ ", doneTime=" + doneTime + "]";
	}
	
}
	

	
