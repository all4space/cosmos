package scit.master.planbe.VO;

public class HistoryVO {

	private int projectNo;
	private String logTime;
	private String logContent;
	
	public HistoryVO(){}
	
	public HistoryVO(int projectNo, String logTime, String logContent) {
		super();
		this.projectNo = projectNo;
		this.logTime = logTime;
		this.logContent = logContent;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	@Override
	public String toString() {
		return "HistoryVO [projectNo=" + projectNo + ", logTime=" + logTime + ", logContent=" + logContent + "]";
	}
	
}
