package scit.master.planbe.VO;

public class PageNavigator {
	private int countPerPage; // 한 페이지에 보여질 게시글 수
	private int pagePerGroup = 5; // 한 페이지에서 보여질 페이지 그룹의 수
	private int currentPage; // 현재 페이지 
	private int totalRecordCount; // 전체 게시글 수 
	private int totalPageCount; // 전체 페이지 수
	private int currentGroup; // 현재 그룹
	private int startPageGroup; // 현재 그룹의 첫 페이지
	private int endPageGroup; // 현재 그룹의 마지막 페이지
	private int startRecord; // 전체 레코드 중 현재 페이지의 첫 글의 위치
	//이젠 srow, erow를 계산하지 않고, mybatis의 기능을 사용할 예정임.
	
	public PageNavigator(int currentPage, int totalRecordCount, int countPerPage) {
		this.totalRecordCount = totalRecordCount;
			
			this.countPerPage = countPerPage;
		// 전체 글 개수 152개라면, 몇페이지? 16페이지
		// 전체 글 개수 150개라면, 몇페이지? 15페이지
			totalPageCount = (totalRecordCount+countPerPage-1) / countPerPage;
			// (10+10) / 10 = 2;
/*			totalRecordCount 
			= (totalRecordCount % COUNT_PER_PAGE > 0) 
			? totalRecordCount/COUNT_PER_PAGE+1 
			: totalRecordCount/COUNT_PER_PAGE;*/
			
			// 현재 페이지 요청 시 계산
			if (currentPage < 1) currentPage = 1;
			if (currentPage > totalPageCount) currentPage = totalPageCount;
			
			this.currentPage = currentPage;
			
			// 현재 그룹 계산 
			// 내가 4페이지를 보고 있다면, 4페이지는 몇번째 페이지 그룹에 속해있는가? 0번 그룹
			currentGroup = (currentPage - 1) / pagePerGroup;
			
			// 현재 그룹의 첫 페이지 계산
			startPageGroup = currentGroup * pagePerGroup + 1;
			startPageGroup = startPageGroup < 1 ? 1 : startPageGroup;
			
			// 현재 그룹의 마지막 페이지 계산
			endPageGroup = startPageGroup + pagePerGroup - 1;
			endPageGroup = endPageGroup < totalPageCount ? endPageGroup : totalPageCount;
			
			// 전체 레코드 중에서 현재 페이지의 첫 글의 위치(RowBounds에서 사용)
			startRecord = (currentPage - 1) * countPerPage;
	}

	//값을 가져가기만 하므로 getter만 잘 만들면 됨.
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getCurrentGroup() {
		return currentGroup;
	}

	public void setCurrentGroup(int currentGroup) {
		this.currentGroup = currentGroup;
	}

	public int getStartPageGroup() {
		return startPageGroup;
	}

	public void setStartPageGroup(int startPageGroup) {
		this.startPageGroup = startPageGroup;
	}

	public int getEndPageGroup() {
		return endPageGroup;
	}

	public void setEndPageGroup(int endPageGroup) {
		this.endPageGroup = endPageGroup;
	}

	public int getStartRecord() {
		return startRecord;
	}

	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getPagePerGroup() {
		return pagePerGroup;
	}

	public void setPagePerGroup(int pagePerGroup) {
		this.pagePerGroup = pagePerGroup;
	}

	@Override
	public String toString() {
		return "PageNavigator [countPerPage=" + countPerPage + ", pagePerGroup=" + pagePerGroup
				+ ", currentPage=" + currentPage + ", totalRecordCount=" + totalRecordCount + ", totalPageCount="
				+ totalPageCount + ", currentGroup=" + currentGroup + ", startPageGroup=" + startPageGroup
				+ ", endPageGroup=" + endPageGroup + ", startRecord=" + startRecord + "]";
	}
	
}
