package com.mashen.domian;

import com.mashen.util.myProperties;

public class PageBean {
	private Integer totalNum;
	private Integer totalPage;
	private Integer currentPage;
	private Integer pageNum;
	
	
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageNum() {
		return Integer.parseInt(myProperties.getProperties("articlePageNum"));
	}
	@Override
	public String toString() {
		return "PageBean [totalNum=" + totalNum + ", totalPage=" + totalPage + ", currentPage=" + currentPage
				+ ", pageNum=" + pageNum + "]";
	}
	
}
