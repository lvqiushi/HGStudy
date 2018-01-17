package cn.lv.hgstudy.common;

import java.util.List;

public class Page {
	private int rowCount;   //记录总数
	private int curPage;    //目前页
	private int pageSize;   //每页记录量
	private int pageCount;  //总页数
	private int star;		
	private int end;
	private List<?> contents;
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public List<?> getContents() {
		return contents;
	}
	public void setContents(List<?> contents) {
		this.contents = contents;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public Page() {
		
	}
	// rowcount 记录总数     page 起始页数    pageSize 每页数量
	public Page(int rowCount, int page, int pageSize) {
		super();
		this.rowCount = rowCount;
		this.pageSize = pageSize;
		if(rowCount==0)
			this.pageCount=1;
		else if(rowCount % pageSize ==0)
			this.pageCount=rowCount / pageSize;
		else
			this.pageCount=rowCount / pageSize + 1;
		
		if(page <= 0 )
			this.curPage = 1;
		else if (page > pageCount)
			this.curPage = pageCount;
		else
			this.curPage = page;
		this.star=this.curPage-2;
		this.end=this.curPage+2;
		if(star<1)
			this.star=1;
		if(this.pageCount==0)
			this.end=1;
		else if(end>pageCount)
			end=pageCount;
	}
	
}
